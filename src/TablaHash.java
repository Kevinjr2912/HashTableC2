import LinkedList.LinkedList;
import Business.Business;
import  LinkedList.Node;

public class TablaHash {
    int size = 50021;
    LinkedList[] linkedListDiv = new LinkedList[size];
    LinkedList[] linkedListMul = new LinkedList[size];
    java.util.LinkedList<Node>[] linkedListJavaDiv = new java.util.LinkedList[size];
    java.util.LinkedList<Node>[] linkedListJavaMult = new java.util.LinkedList[size];


    public void insercion(int opcion, String id, Business objBusiness){
        int indiceReferencia = this.convertirASCII(id);
        int espacioTablaHashDiv = this.hashDivision(indiceReferencia);
        int espacioTablaHashMult = this.hashMultiplicacion(indiceReferencia);
        Node node = new Node(objBusiness);

        if( opcion == 1 ){
            if(this.linkedListDiv[espacioTablaHashDiv] == null){
                this.linkedListDiv[espacioTablaHashDiv] = new LinkedList();
            }

            this.linkedListDiv[espacioTablaHashDiv].push(objBusiness);

        }else if( opcion == 2 ){
            if(this.linkedListMul[espacioTablaHashMult] == null){
                this.linkedListMul[espacioTablaHashMult] = new LinkedList();
            }

            this.linkedListMul[espacioTablaHashMult].push(objBusiness);

        }else if( opcion == 3 ){
            if(this.linkedListJavaDiv[espacioTablaHashDiv] == null){
                this.linkedListJavaDiv[espacioTablaHashDiv] = new java.util.LinkedList<>();
            }

            this.linkedListJavaDiv[espacioTablaHashDiv].add(node);

        }else{
            if(this.linkedListJavaMult[espacioTablaHashMult] == null){
                this.linkedListJavaMult[espacioTablaHashMult] = new java.util.LinkedList<>();
            }

            this.linkedListJavaMult[espacioTablaHashMult].add(node);

        }
    }

    public int convertirASCII(String id){
        int suma = 0;

        for(int i=0; i<id.length(); i++){
            char caracter = id.charAt(i);
            int valorASCCI = (int) caracter;
            suma += valorASCCI;
        }

        return suma;
    }

    public int hashDivision(int indiceReferencia){
        int clave = indiceReferencia % size;
        return clave;
    }

    public int hashMultiplicacion(int indiceReferencia){
        double aurea = 0.3565;
        double producto = (size * ((indiceReferencia * aurea) % 1));

        int clave = (int) producto;
        return clave;
    }

    public Node busqueda(int opcion,String clave){
        int referencia = this.convertirASCII(clave);
        int espacioTablaHashDiv = this.hashDivision(referencia);
        int espacioTablaHashMult = this.hashMultiplicacion(referencia);
        long timeInicio = System.nanoTime();
        Node nodoEncontrado = null;

        if( opcion == 1 && this.linkedListDiv[espacioTablaHashDiv] != null ){
            for(int i=0; i<this.linkedListDiv[espacioTablaHashDiv].size(); i++){
                Node nodoBuscar = this.linkedListDiv[espacioTablaHashDiv].getElementAt(i);
                if(nodoBuscar.getObjBusiness().getId().equals(clave)){
                    nodoEncontrado = nodoBuscar;
                    i = this.linkedListDiv.length;
                }
            }

        } else if( opcion == 2 && this.linkedListMul[espacioTablaHashMult] != null ){
            for(int i=0; i<this.linkedListMul[espacioTablaHashMult].size(); i++){
                Node nodoBuscar = this.linkedListMul[espacioTablaHashMult].getElementAt(i);
                if(nodoBuscar.getObjBusiness().getId().equals(clave)){
                    nodoEncontrado = nodoBuscar;
                    i = this.linkedListMul.length;
                }
            }
        } else if( opcion == 3 && this.linkedListJavaDiv[espacioTablaHashDiv] != null ){
            for(int i=0; i<this.linkedListJavaDiv[espacioTablaHashDiv].size(); i++){
                Node nodoBuscar = this.linkedListJavaDiv[espacioTablaHashDiv].get(i);
                if(nodoBuscar.getObjBusiness().getId().equals(clave)){
                    nodoEncontrado = nodoBuscar;
                    i = this.linkedListJavaDiv.length;
                }
            }
        } else if( opcion == 4 && this.linkedListJavaMult[espacioTablaHashMult] != null ){
            for(int i=0; i<this.linkedListJavaMult[espacioTablaHashMult].size(); i++){
                Node nodoBuscar = this.linkedListJavaMult[espacioTablaHashMult].get(i);
                if(nodoBuscar.getObjBusiness().getId().equals(clave)){
                    nodoEncontrado = nodoBuscar;
                    i = this.linkedListJavaMult.length;
                }
            }
        }

        long timeFinal = System.nanoTime();
        long time = timeFinal - timeInicio;
        double seconds = time / 1_000_000.0;
        System.out.println("El tiempo de ejecución fue: " + seconds);
        return nodoEncontrado;
    }

}