#include <iostream>

int get_change(int m) {
  //write your code here
  return m / 4;
}

int main() {
  int m;
  std::cin >> m;
  std::cout << get_change(m) << '\n';
}
