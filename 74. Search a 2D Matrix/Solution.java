class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0){
            return false;
        }
        
        int n = matrix[0].length;
        if (n == 0){
            return false;
        }
        for(int i=0; i < m; i++){
            for(int j=0; j < n; j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        // int high = m;
        // int low = 0;
        // int mid = (high + low) / 2;
        // while(low <= high){
        //     if (target > matrix[mid][0]){
        //         low = mid + 1;
        //         mid = (high + low) / 2;                
        //     }else if(target < matrix[mid][0]){
        //         high = mid - 1;
        //         mid = (high + low) / 2;  
        //     }
        //     else{
        //         return true;
        //         }    
        // }
    
        // int high2 = n;
        // int low2 = 0;
        // int mid2 = (high2 + low2) / 2;
        // while(low2 <= high2) {
        //     if (target > matrix[low][mid2]){
        //         low2 = mid2 + 1;
        //         mid2 = (high2 + low2) / 2;                
        //     }else if(target < matrix[low][mid2]){
        //         high2 = mid2 - 1;
        //         mid2 = (high2 + low2) / 2;  
        //     }
        //     else{
        //         return true;
        //         }
        // }
        return false;
    }
}