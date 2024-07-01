import Business.Business;
import LinkedList.Node;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TablaHash tablaHash = new TablaHash();
        menu(tablaHash);
    }

    public static void menu(TablaHash tablaHash){
        Scanner entrada = new Scanner(System.in);
        int opcion = 0;

        System.out.println("<----------------------- BIENVENIDO -------------------------------->");

        do{
            do{
                System.out.println("\n¿POR QUÉ MÉTODO LE GUSTARÍA REALIZAR LA BÚSQUEDA? \n\n-------------------PROPIA----------------- \n1.DIVISIÓN \n2.MULTIPLICACIÓN " +
                        "\n---------------------JAVA----------------- \n3.DIVISIÓN \n4.MULTIPLICACION");
                opcion = entrada.nextInt();

                if(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4) {
                    System.out.println("INGRESE NÚMEROS VÁLIDOS");
                }

            }while(opcion<1 || opcion>4);

            entrada.nextLine();

            leerArchivoCsv(tablaHash,opcion);

            System.out.print("INGRESE EL ID DE DICHO ELEMENTO: ");
            String id = entrada.nextLine();

            Node nodo = tablaHash.busqueda(opcion,id);

            //7BPPs1Jzx8hMBDgMJYpwfQ
            if(nodo == null){
                System.out.println("No existe dicho elemento");
            }

            else{
                System.out.println("\nDatos de ese objeto { " + "\n" + "Nombre: " + nodo.getObjBusiness().getName() + "\n" + "Dirección:" + nodo.getObjBusiness().getAddress()
                        + "\n" +  "Ciudad: " + nodo.getObjBusiness().getCity() + "\n" +  "Estado: " + nodo.getObjBusiness().getState() + "\n}");
            }

            System.out.println("\n¿DESEA SEGUIR BUSCANDO DICHOS ELEMENTOS? 1.Si 2.No");
            opcion = entrada.nextInt();

            entrada.nextLine();

        }while(opcion != 2);
    }

    public static void leerArchivoCsv(TablaHash tablaHash,int opcion){
        String line = "";
        String splitBy = ",";

        try
        {
            BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] bussines = line.split(splitBy);// use comma as separator
                String id = bussines[0], name = bussines[1],address = bussines[2],city = bussines[3],state = bussines[4];
                Business objBusiness = new Business(id,name,address,city,state);
                tablaHash.insercion(opcion,bussines[0],objBusiness);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
