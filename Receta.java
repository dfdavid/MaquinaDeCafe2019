import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class Receta {
    protected Map<Ingrediente, Integer> ingredientes;
    
    public Receta (){
        ingredientes = new TreeMap<Ingrediente,Integer>();
    }
    
    /**
     * Agrega un ingrediente a la receta
     * 
     * @param ing el Ingrediente a agregar a la receta
     * @param cantidad la cantidad de ingrediente a agregar a la receta
     * @throws IllegalArgumentException cuando no hay ingrediente o la
     * cantidad a agregar no es valida (ej. valor negativo)
     */
    public void agregarIngrediente(Ingrediente ingredienteNuevo, Integer cantidad){
        //TODO implementar el metodo

        //validar ingrediente
        int ingredientValido=0;
        for ( Ingrediente ing: Ingrediente.values() ){
            if( ing.equals(ingredienteNuevo) ) {
                ingredientValido++;
            }
        }
        //validar cantidad
        if (cantidad<0 || cantidad > Recipiente.CAPACIDAD_MAXIMA_DEFAULT ){
            throw new IllegalArgumentException("Cantidad de ingrediente no valida");
        }
        //si el ingrediente es valido se agrega a la receta
        if (ingredientValido>0){
            ingredientes.put( ingredienteNuevo , cantidad);
        }
        //si el ingrediente es invalido se arroja una excepcion
        else{
            throw new IllegalArgumentException("Ingrediente no valido");
        }
    }
    
    /**
     * Devuelve el mapa de ingredientes y cantidades de esta receta
     * 
     * @return el mapa de los ingredientes y su cantidad
     */
    public Map<Ingrediente, Integer> getMapaDeIngredientes(){
        //TODO implementar el metodo
        return null;
    }
    
    /**
     * Devuelve la lista de ingredientes de esta receta
     * 
     * @return la lista de ingredientes de la receta
     */
    public List<Ingrediente> getIngredientes(){
        //TODO implementar el metodo
        return null;
    }
    
    /**
     * Retorna la cantidad del ingrediente solicitado para esta
     * receta. Si la receta no requiere este ingrediente, retorna 0
     * 
     * @param ingrediente el ingrediente solicitado
     * @return la cantidad de ingrediente requerida por la receta
     */
    public int getCantidadDeIngrediente (Ingrediente ingrediente){
        //TODO implementar el metodo
        return -1;
    }

    /**
     * Retorna un String con el siguiente formato:
     * 
     *  "Receta: <Ingrediente1>[<Cantidad1>];<Ingrediente2>[<Cantidad2>];...;<IngredienteN>[<CantidadN>];"
     *  
     *  Ej.:
     *  "Receta: AZUCAR[5];AGUA[150];CAFE[15];"
     *  
     * @return String con la informacion de ingredientes de la receta 
     */
    public String toString(){
        //TODO implementar el metodo
        return "";

    }
    
}
