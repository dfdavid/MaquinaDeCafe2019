import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaquinaDeCafe implements MaquinaDeEstados {
    protected Producto seleccion;
    protected Estado estado = Estado.APAGADO;
    protected List <Recipiente> recipientes;
    protected Map <Producto, Receta> recetas; 
    protected int totalProductosServidos;

    
    /**
     * Constructor sin parametros.
     */
    public MaquinaDeCafe(){
        recipientes = new ArrayList<Recipiente>();
        recetas = new HashMap<Producto,Receta>();
        totalProductosServidos = 0;
        
    }
        
    /**
     * Retorna la cantidad total de productos servidos por esta maquina.
     * 
     * @return cantidad total de productos servidos
     */
    public int getTotalProductosServidos() {
        return totalProductosServidos;
    }
        
    /**
     * Retorna los productos y recetas configurados en esta
     * maquina de cafe
     * 
     * @return mapa con productos y recetas asociadas
     */
    public Map<Producto, Receta> getRecetas() {
        return recetas;
    }
       
    /**
     * Retorna los recipientes configurados en esta maquina de cafe
     * 
     * @return lista de los recipientes
     */
    public List<Recipiente> getRecipientes() {
        return recipientes;
    }
        
    /**
     * Retorna el producto (receta) seleccionado
     * 
     * @return el producto seleccionada en la maquina
     */
    public Producto getSeleccion() {
        return seleccion;
    }
       
    /**
     * Valida si es posible despachar el producto especificaod
     * 
     * @param p el producto a despachar
     * @throws ProductoException si el producto especificado es null, o no esta
     * configurado en esta maquina, o existen ingredientes faltantes en la receta.
     * 
     */
    public void validarProducto(Producto p) throws ProductoException{
        if (p==null || !recetas.containsKey(p) )
            throw new ProductoException("No existe receta para la seleccion "+ seleccion);
        
        Receta r = recetas.get(p);
        for (Ingrediente ing: r.getIngredientes()){
            if (!hayIngredienteDisponible(ing, r.getCantidadDeIngrediente(ing)))
                throw new ProductoException("Hay faltantes para la seleccion "+seleccion);
        }
    }

    
    
    
    
    
    
// A PARTIR DE AQUI SON METODOS A MODIFICAR EN EL EXAMEN (NO MODIFICAR LOS ANTERIORIES)
        
    	/**
	 * Ejecuta la receta para el producto especificado, extrayendo
	 * de cada recipiente la cantidad necesaria de ingredientes
	 * para preparar la receta
	 * 
	 * @param el producto seleccionado
	 * @throws ProductoException si por algun motivo no se puede
	 * extraer la cantidad requerida de cada ingrediente
	 */
	public void prepararProducto(Producto seleccion) throws ProductoException {
		//TODO implementar el metodo
		
		if (seleccion == null || !recetas.containsKey(seleccion)) {
            throw new ProductoException("No existe receta para la seleccion " + seleccion);
        }
        Receta r = recetas.get(seleccion);
        for (Ingrediente ing : r.getIngredientes()) {
            if (!hayIngredienteDisponible(ing, r.getCantidadDeIngrediente(ing))) {
                throw new ProductoException("Hay faltantes para la seleccion " + seleccion);
            }
        }

        for (Ingrediente ingr : r.getMapaDeIngredientes().keySet()) {
            for (Recipiente recip : recipientes) {
                if (recip.getTipoIngredienteAlmacenado() == ingr) {
                    try {
                        recip.extraer(r.getMapaDeIngredientes().get(ingr));
                    } catch (CapacidadExcedidaException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
	

	}
    
    
    
    
    
    
    
    /**
     * Verifica si existe suficiente cantidad de un ingrediente
     * especificado
     * 
     * @param ingrediente el ingrediente requerido
     * @param cantidadRequerida la cantidad requerida
     * @return true si existe suficiente ingrediente, false en
     * caso contrario.
     */
    public boolean hayIngredienteDisponible (Ingrediente ingrediente, int cantidadRequerida){
        //TODO implementar el metodo

        return false;
    }

    
    
    
    
    
    /**
     * Retorna el recipiente para el producto especificado
     * 
     * @param ingrediente el ingrediente requerido
     * @return el recipiente que contiene el ingrediente
     * requerido, o null si no existe un recipiente para ese
     * ingrediente.
     */
    public Recipiente getRecipiente (Ingrediente ingrediente){
		//TODO implementar el metodo
		for (Recipiente r : recipientes) {
            if (ingrediente == r.getTipoIngredienteAlmacenado()) {
                return r;
            }
        }
        return null;
	
	}
    
    /**
     * Agrega una receta para un producto de la maquina de
     * cafe. Solo es valido en modo MANTENIMIENTO
     * 
     * @param r la Receta correspondiente al producto a agregar.
     * @param p el Producto a agregar y configurar en la maquina.
     * @throws IllegalStateException si la maquina no esta en modo MANTENIMIENTO
     */
    public void agregarReceta (Receta r, Producto p) throws Exception {
        //TODO implementar el metodo
        
        if (this.estado != Estado.MANTENIMIENTO ){
            throw new IllegalStateException();
        }
        else{
            //compruebo si el producto es valido
            boolean productoValido=false;
            for ( Producto prodEnum:  Producto.values()){
                   if( prodEnum.equals(p)  ){
                       productoValido=true;
                   }
            }                
            
            if (productoValido==false){
                throw new Exception("Producto invalido");
            }
            //verifico si ya existe la receta para ese prod
            if ( recetas.containsKey(p) ){
                //si existe la reemplazo
                recetas.replace(p, r);
            }
            else{
                //si no, la agrego
                recetas.put(p,r);
            }   
        }
    }
    
    
    
    /**
     * Borra los productos y recetas cargadas en la maquina. Solo
     * es valido en modo MANTENIMIENTO
     * 
     * @throws Illeg al   StateException si la maquina no esta en modo MANTENIMIENTO
     */
    public void limpiarRecetas (){
        //TODO implementar el metodo
    }

    /**
     * Selecciona un producto para despachar. Solo es posible si
     * la maquina esta lista para despachar el producto
     * 
     * @param seleccion el producto a despachar
     * @throws IllegalStateException si la maquina no esta lista
     */
    public void setSeleccion(Producto selecciono) throws Exception{
        //TODO implementar el metodo
        //Verifico que la maquina esta lista. Si no, arroja IllegalStateException
        if ( this.estado != Estado.LISTO ){
            throw new IllegalStateException("La maquina no esta lista");
        }
        
        //Verifico si el producto esta en el enum
        boolean prodValido=false;
        for( Producto prod: Producto.values() ){
            if( prod.equals(selecciono) ){
                prodValido=true;
            }
        }
        
        if(prodValido){
            //si el producto es valido cambio el campo seleccion
            this.seleccion=selecciono;
        }
        else{
            //si no, arroja una excepcion.
            throw new Exception("Seleccion de un producto invalido");
        }
        
    }

    /**
     * 
     * vinculo recipientes a la maquina (esto no esta en el tp)
     * 
     */
    public void addRecipiente(Recipiente siloNuevo){
        this.recipientes.add(siloNuevo);
    
    }
    
       
    
    /* Metodos de la interface */

    @Override
    public Estado getEstado() {
        //TODO implementar el metodo
        return this.estado;
    }
    
    @Override
    public void operar() throws IllegalStateException {
        //TODO implementar el metodo
        //Verificar si la maquina esta lista
        if( this.estado != Estado.LISTO  ){
            throw new IllegalStateException("La maquina no está lista");
        }
         
        
        // - cambia el Estado de la maquina a OPERANDO
        this.estado=Estado.OPERANDO;
             
        
        // - incrementa la cuenta de productos despachados
        this.totalProductosServidos++;
                
    }

    @Override
    public void restablecer() {
        //TODO implementar el metodo
        // - cambia el Estado de la maquina a LISTO
        this.estado=Estado.LISTO;
        
        // - establece la seleccion de producto en null    
        this.seleccion=null;
    }

    @Override
    public void encender() throws IllegalStateException {
        //TODO implementar el metodo
        //Verifico si esta en APAGADO
                if (this.estado != Estado.APAGADO){
            throw new IllegalStateException();
        }
        //Cambio a estado LISTO
        this.estado=Estado.LISTO;
        //blanqueo el campo seleccion
        this.seleccion=null;
    }

    @Override
    public void apagar() {
        //TODO implementar el metodo
        //verifico si al maq esta encendida
        if( this.estado == Estado.OPERANDO ){
            throw new IllegalStateException();
        }
        
        this.estado=Estado.APAGADO;
    }

    @Override
    public void mantener() {
        //TODO implementar el metodo        
        
        // - lanza IllegalStateException si la maquina no esta LISTA
        
        
        // - cambia el Estado de la maquina a MANTENIMIENTO
        
        
    }
    
}
