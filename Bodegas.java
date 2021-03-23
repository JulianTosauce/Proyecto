
/**
 * Write a description of class Bodegas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bodegas
{
   // matrices camara frontal
    private int[][] bodegafront;
    private int[][] bodegafrontP;
    
    // matrices camara lateral
    private int[][] bodegaLeft;
    private int[][] bodegaleftP;
        
    
    
    /**
     * Calcula la matriz de la camara lateral deado el plano de la bodega
     * 
     */
    public int[][] bodegaLeft(int[][] bodega,int max ,int length){
        bodegaLeft = new int[max][length];
        int maxFil = 0; 
        int cont = 1; //Corresponde a las columnas
        int its =0; // corresponde a la condicion de si esta en determinada fila
        
        for(int i = bodega.length - 1 ; i >= 0 ; i--){
            its = bodegaLeft.length ;
            for(int j = bodega[i].length - 1; j >= 0; j--){
                
                if (bodega[i][j] > maxFil){
                    maxFil=bodega[i][j];
                }
            }
            
            while(its > 0 ){
                if(max - its +1 <= maxFil ){
                    bodegaLeft[its-1][cont-1]= 1;
                }else{
                    bodegaLeft[its-1][cont-1]= 0;
                }
                its--;
            }
            cont++;
            maxFil = 0;
        }
        
        
        return bodegaLeft;
    }
    
    
    /**
     * Calcula matriz del la camara frontal dado el plano de la bodega
     */
    public int[][] bodegaFront(int[][] bodega,int max ,int width){
        bodegafront = new int[max][width];
        int maxCol = 0; 
        
        // mat de bodega
        for(int i = 0 ; i < bodega[0].length ; i++){
            for(int j = 0; j < bodega.length;j++){
                if (bodega[j][i]>maxCol){
                    maxCol=bodega[j][i];
                }
            }
            for(int l = 0; l < bodegafront.length ; l++){
                if(maxCol+l >= max){
                    bodegafront[l][i] = 1;
                }else{
                    bodegafront[l][i] = 0;
                }
            }
            maxCol = 0;
        }
        
        
        
        return bodegafront;
    }
}
