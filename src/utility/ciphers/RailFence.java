package utility.ciphers;


import java.*;
import java.util.*;


/**
 *
 * @author Lester
 */


public class RailFence{
	
	public String encrypt(String cypherText, int key){
		char[][] matrix = new char[key][cypherText.length()]; 
		
		int row = 0;
		boolean down = true; 
		for (int i = 0; i < cypherText.length(); i++){ 
			matrix[row][i] = cypherText.charAt(i); 
			
			if (down){
				row++;
				if (row == matrix.length){
					row = matrix.length - 2; 
					down = false; 
				} 
			}else{ 
				row--;
				
				if (row == -1){
					row = 1; 
					down = true;
				}
			}
		}
		
		
		StringBuffer sb = new StringBuffer();
		for (row = 0; row < matrix.length; row++){ 
			for (int col = 0; col < matrix[row].length; col++){ 
				if (matrix[row][col] > '0') sb.append(matrix[row][col]);
			}
		}
		
		return sb.toString();
	}
	
	public String decrypt(String cypherText, int key){
		char[][] matrix = new char[key][cypherText.length()];
		
		int targetRow = 0;
		int index = 0;
		do{
			int row = 0;		
			boolean down = true; 
			for (int i = 0; i < cypherText.length(); i++){
				if (row == targetRow){
					matrix[row][i] = cypherText.charAt(index); 
					index++;
				}
				
				if (down){
					row++;
					if (row == matrix.length){ 
						row = matrix.length - 2; 
						down = false; 
					} 
				}else{ 
					row--;
					
					if (row == -1){
						row = 1;
						down = true;
					}
				}
			}

			targetRow++;
		}while (targetRow < matrix.length);
		
		
		StringBuffer sb = new StringBuffer(); 
		int row = 0;
		boolean down = true;
		for (int col = 0; col < matrix[row].length; col++){ 
			sb.append(matrix[row][col]); 
			
			if (down){ 
				row++;
				if (row == matrix.length){ 
					row = matrix.length - 2;
					down = false; 
				} 
			}else{ 
				row--;
				
				if (row == -1){ 
					row = 1;
					down = true;
				}
			}

		}
		
		return sb.toString();
	}
	
	private void printMatrix(char[][] matrix){
		for (int row = 0; row < matrix.length; row++){ 
			for (int col = 0; col < matrix[row].length; col++){ 
				System.out.print(matrix[row][col]);
				if (col < matrix[row].length - 1) System.out.print(",");
			}
			System.out.println();
		}
	}
		
	public static void main(String[] args) throws Exception{
		
	}
}