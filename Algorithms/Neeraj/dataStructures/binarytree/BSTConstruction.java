class BSTConstruction{
  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {
      if(value < this.value){
				if(left == null)left = new BST(value);
				else left = left.insert(value);
			}else{
				if(right == null) right = new BST(value);
				else right = right.insert(value);
			}
      return this;
    }

    public boolean contains(int value) {
      if(this.value == value) return true;
			else if(value < this.value) return left.contains(value);
			else return right.contains(value);
    }

    /*
    public BST remove(int value) {
// 			Find the element.
			if(value < this.value) return left.remove(value);
			else if (value > this.value) return right.remove(value);
			else{
// 				The element is found, check one of the three conditions.
        // If there are no any childs then this becomes null.
				if(left == null && right == null) return null;
				else if (left == null){
          // If there is only right then set the right node value to current and set right to null.
					this = right;
				}else if(right == null){
					this = left;
				}else{
// 					Find the lowest value at right.
          int lowest = right.findLowest();
          // Remove the lowest value from the right node.
          right = right.remove(lowest);
          this.value = lowest;
				}
			}
      return this;
    }

     */
    public int findLowest(){
      // This is to get the Lowest Value
      if(left != null) return left.findLowest();
      else return value;
    }
  }
}
