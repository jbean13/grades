/*
 */
package org.ld.mergeSort;

public class MergeSort {
    
    public void fillRaw(int[] raw) {
        for (int i=0; i<raw.length; i++) raw[i] = (int) (Math.random()*100);
    }
    
    public void show(int[] raw) {
        for (int i=0; i<raw.length; i++) System.out.print(raw[i]+" ");
        System.out.println("");
    }
    public int[] getSorted(int [] raw) {
        
        if (raw.length<=1) return raw;
        int midpoint = raw.length/2;
        int [] left = new int[midpoint];
        int [] right = new int[raw.length-midpoint];
        int [] sorted;
        
        for (int i=0; i<midpoint ; i++) left[i] = raw[i];
        for (int i=midpoint; i<raw.length; i++) right[i-midpoint]=raw[i];
        
        left = getSorted(left);
        right = getSorted(right);
        sorted = merge(left, right);
        return sorted;
    }
    
    public int[] merge(int[] left, int[] right) {
        int len = left.length + right.length;
        int [] result = new int[len];
        int iResult=0;
        int i=0, j=0;
        
        //System.out.println("*** LEFT"); show(left);
        //System.out.println("*** RIGHT"); show(right);
        
        while (i<left.length) { // i is current left index
            while (j<right.length) { // j is current right index
                if (left[i] <= right[j]) {
                    result[iResult] = left[i]; 
                    //System.out.println("LEFT= "+i+", "+left[i]+", "+iResult+", "+result[iResult]);
                    iResult++;
                    if (i==left.length-1) { // end of the left, move all items in the right
                        for (int k=j; k<right.length; k++) {
                            result[iResult] = right[k]; iResult++;
                        }
                    }
                    i++;
                    break;
                } else {
                    result[iResult] = right[j];
                    //System.out.println("RIGHT= "+j+", "+right[j]+", "+iResult+", "+result[iResult]);
                    iResult++;
                    if (j==right.length-1) { // end of the right, move all items in the left
                        for (int k=i; k<left.length; k++) {
                            result[iResult] = left[k]; iResult++;
                        }
                        i=left.length;
                    }
                     j++;
                }
            }
        }
        //show(result);
        return result;
        
    }
    
}
