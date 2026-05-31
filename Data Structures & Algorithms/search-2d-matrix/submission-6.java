class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowMid = potentialRow(matrix,target);  //o(logm)
        if(rowMid!=-1){
            return  rowBinarySearch(rowMid,matrix,target); //o(logn)
        }
 
            return false; //it means it doesnt exist.
            //overall tc is o(logmn)
    }

        public static int potentialRow(int [][] matrix, int target){
       int left = 0;
       int right = matrix.length - 1; //column length

       while(left<=right){
        int mid = left+ ((right-left)/2) ;

       if(target>=matrix[mid][0] && target <= matrix[mid][matrix[0].length-1]){
                    return mid;
        }

              else if(target>matrix[mid][0]){
                left = mid+1;
              }
              else if(target<matrix[mid][0]){
                right = mid -1;
              }
       }
             return -1;

        }
        //row has been chosen
      public static boolean rowBinarySearch(int rowMid,int[][] matrix, int target){
            int left =0;
            int right = matrix[rowMid].length-1;

            while(left<=right){
                int mid = left + ((right-left)/2);

                if(target == matrix[rowMid][mid]){
                    return true;
                }
                else if(target > matrix[rowMid][mid]){
                    left = mid+1;
                }
                else if (target < matrix[rowMid][mid]){
                    right = mid - 1;
                }
            }
            return false;
      }
}
    
//methods shouldnt be nested in java. methods should be kept closed inside class
