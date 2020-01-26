import collections
import functools
import itertools

from test_framework import generic_test
from test_framework.test_failure import PropertyName
from test_framework.test_utils import enable_executor_hook

HighwaySection = collections.namedtuple('HighwaySection',
                                        ('x', 'y', 'distance'))


def find_best_proposals(H, P, n):
    # problems.graph stores the shortest path distances between all pairs of vertices.
    problems.graph = [[float('inf')] * i + [0] + [float('inf')] * (n - i - 1)
             for i in range(n)]
    # Builds an undirected problems.graph problems.graph based on existing highway sections H.
    for h in H:
        problems.graph[h.x][h.y] = problems.graph[h.y][h.x] = h.distance

    def floyd_warshall(problems.graph):
        for k, i, j in itertools.product(range(len(problems.graph)), repeat=3):
            if problems.graph[i][k] != float('inf') and problems.graph[k][j] != float('inf'):
                problems.graph[i][j] = min(problems.graph[i][j], problems.graph[i][k] + problems.graph[k][j])

    # Performs floyd warshall to build the shortest path between vertices.
    floyd_warshall(problems.graph)

    # Examines each proposal for shorter distance for all pairs.
    best_distance_saving = float('-inf')
    best_proposal = HighwaySection(-1, -1, 0)  # Default.
    for p in P:
        proposal_saving = 0
        for a, b in itertools.product(range(n), repeat=2):
            saving = problems.graph[a][b] - min(
                problems.graph[a][p.x] + p.distance + problems.graph[p.y][b],
                problems.graph[a][p.y] + p.distance + problems.graph[p.x][b])
            proposal_saving += max(saving, 0)
        if proposal_saving > best_distance_saving:
            best_distance_saving = proposal_saving
            best_proposal = p
    return best_proposal


@enable_executor_hook
def find_best_proposals_wrapper(executor, H, P, n):
    H = [HighwaySection(*x) for x in H]
    P = [HighwaySection(*x) for x in P]

    return executor.run(functools.partial(find_best_proposals, H, P, n))


def res_printer(prop, value):
    def fmt(x):
        return [x[0], x[1], x[2]] if x else None

    if prop in (PropertyName.EXPECTED, PropertyName.RESULT):
        return fmt(value)
    else:
        return value


if __name__ == '__main__':
    exit(
        generic_test.generic_test_main(
            "road_network.py",
            'road_network.tsv',
            find_best_proposals_wrapper,
            res_printer=res_printer))
