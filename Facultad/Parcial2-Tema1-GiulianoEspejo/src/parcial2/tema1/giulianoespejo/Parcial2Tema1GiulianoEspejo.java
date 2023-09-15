/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2.tema1.giulianoespejo;

import java.util.Date;

/**
 *
 * @author giuli
 */
public class Parcial2Tema1GiulianoEspejo {

    /**
     * @param args the command line arguments
     */
    /*
    
    • Mencione el nombre, correo electrónico de un usuario, con la fecha de inicio y fin de al menos 2 préstamos solicitados, verifique si ha realizado reserva previa del algunos de los documentos que se le presto. Mencione los documentos (2 mínimo) que le fueron prestados, su título, biblioteca, editorial, autor o autores a los que pertenece cada documento. 

    • Muestre una lista de 2 CD, 2 DVD, 2 Revistas Científicas y 2 Revista Deportivas existentes en una biblioteca, con los autores de cada caso, según corresponda. Para ello debe mencionar todos los atributos pertenecientes a dichas clases. 

    • En todos los casos podrá crear constructores y los métodos que le sean necesarios para reflejar adecuadamente las asociaciones que se observa en el diagrama. 

    */
    public static void main(String[] args) {

        /*
        ----------------------------------
               Creacion del Usuario
        ----------------------------------
         */
        Usuario user1 = new Usuario("Giuliano Espejo", "giulianoespejo@gmail.com");
        Biblioteca biblio1 = new Biblioteca("Biblioteca de la UTN");
        Editorial editorial1 = new Editorial("Bizarap");
        Categoria categoria1 = new Categoria("Musica");

        user1.addReservas(new Reserva(new Date("03/06/2023"), new Documento("Alquiler cd Rosalia", biblio1, editorial1, categoria1)));
        user1.addPrestamos(new Prestamo(new Date("03/10/2023"), new Date("03/15/2023"), user1.getReservas().get(0).getDocumentos().get(0)));
        user1.addPrestamos(new Prestamo(new Date("03/12/2023"), new Date("03/17/2023"), new Documento("Alguiler cd Shakira", biblio1, editorial1, categoria1)));
        user1.getPrestamos().get(0).getDocumentos().get(0).addAutores(new Autor("Shakira", "", user1.getPrestamos().get(0).getDocumentos().get(0)));
        user1.getPrestamos().get(1).getDocumentos().get(0).addAutores(new Autor("Rosalia", "", user1.getPrestamos().get(0).getDocumentos().get(0)));
        
        /*
        ----------------------------------
            Mostrar datos del usuario
        ----------------------------------
         */
        System.out.println(user1.toString());
        System.out.println("Fechas de inicio y fin de prestamos");
        for (Prestamo prestamo : user1.getPrestamos()) {
            System.out.println("----------------------");
            System.out.println("Fecha incio: " + prestamo.getFechaDeInicio());
            System.out.println("Fecha fin: " + prestamo.getFechaDedevolicion());
        }
        System.out.println("----------------------");
        /*
        ----------------------------------
            Mostrar si hubo reservas
        ----------------------------------
         */
        System.out.println("");
        if(user1.getPrestamos().get(0).chequeReserva(user1.getReservas().get(0))){
            System.out.println("El usuario realizo una reserva");
        }
        else{
            System.out.println("El usuario no realiso una resever");
        }
        System.out.println("");
        /*
        ----------------------------------
         MOSTRAR DOCUMENTOS DEL USUARIO
        ----------------------------------
         */
        
        if (user1.getPrestamos().size() > 0) {
            System.out.println("Documentos del usuario respecto a sus prestamos");
            for (Prestamo prestamo : user1.getPrestamos()) {
                for (Documento docu : prestamo.getDocumentos()) {
                    System.out.println("---------------------");
                    System.out.println(docu.toString());
                    System.out.println("Autor/Autores");
                    for (int i = 0; i < docu.getAutores().size(); i++) {
                        System.out.println("Nombre " + docu.getAutores().get(i).getNombre());
                        System.out.println("Apellido" + docu.getAutores().get(i).getApellido());
                    }
                    System.out.println("---------------------");
                }
            }
        }
        
        
        System.out.println("");
        System.out.println("Lista:  2 CD, 2 DVD, 2 Revistas Científicas y 2 Revista Deportivas ");
        System.out.println("");
        /*
        ----------------------------------
           Crear CDs DVDs y Revistas
        ----------------------------------
         */
        CD cd1 = new CD("Shakira", "Cd Shakira", biblio1, editorial1, categoria1);
        CD cd2 = new CD("Rosalia", "Cd Rosalia", biblio1, editorial1, categoria1);
        cd1.addAutores(new Autor("Shakira", "", cd1));
        cd2.addAutores(new Autor("Rosalia", "", cd2));

        System.out.println("CDs");

        System.out.println(cd1.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < cd1.getAutores().size(); i++) {
            System.out.println("Nombre: " + cd1.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + cd1.getAutores().get(i).getApellido());
        }

        System.out.println("------------------------------");

        System.out.println(cd2.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < cd2.getAutores().size(); i++) {
            System.out.println("Nombre: " + cd2.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + cd2.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");
        
        System.out.println("");
        System.out.println("DVDs");
        System.out.println("");
        Editorial editorial4 = new Editorial("Editorial de musica");
        DVD dvd1 = new DVD(40, "DVD Gardel", biblio1, editorial4, categoria1);
        DVD dvd2 = new DVD(60, "DVD La Konga", biblio1, editorial4, categoria1);
        dvd1.addAutores(new Autor("Carlos", "Gardel", dvd1));
        dvd2.addAutores(new Autor("Grupo", "La konga", dvd2));

        System.out.println(dvd1.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < dvd1.getAutores().size(); i++) {
            System.out.println("Nombre: " + dvd1.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + dvd1.getAutores().get(i).getApellido());
        }

        System.out.println("------------------------------");

        System.out.println(dvd2.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < cd2.getAutores().size(); i++) {
            System.out.println("Nombre: " + dvd2.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + dvd2.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");

        System.out.println("");
        System.out.println("Revistas Cientificas");
        System.out.println("");
        Categoria categoria2 = new Categoria("Ciencia");
        Editorial editorial2 = new Editorial("Oxford");
        RevistaCientifica revistaCientifica1 = new RevistaCientifica(123, "Cientificos descubren agua en marte", biblio1, editorial2, categoria2);
        RevistaCientifica revistaCientifica2 = new RevistaCientifica(112, "Cientificos descubren vida inteligente en otra galaxia", biblio1, editorial2, categoria2);
        revistaCientifica1.addAutores(new Autor("Jorge", "Gutierres", revistaCientifica1));
        revistaCientifica1.addAutores(new Autor("Pedro", "Sanches", revistaCientifica1));
        revistaCientifica2.addAutores(revistaCientifica1.getAutores().get(0));
        
        System.out.println(revistaCientifica1.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < revistaCientifica1.getAutores().size(); i++) {
            System.out.println("Nombre: " + revistaCientifica1.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + revistaCientifica1.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");

           
        System.out.println(revistaCientifica2.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < revistaCientifica2.getAutores().size(); i++) {
            System.out.println("Nombre: " + revistaCientifica2.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + revistaCientifica2.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");

        System.out.println("");
        System.out.println("Revistas de Deportes");
        System.out.println("");
        
        Categoria categoria3 = new Categoria("Deportes");
        Editorial editorial3 = new Editorial("Ole");
        RevistaDeportiva deporte1 = new RevistaDeportiva("futbol", "Sacachispas campeon de la libertadores ", biblio1, editorial3, categoria3);
        RevistaDeportiva deporte2 = new RevistaDeportiva("F1", "Alonzo hizo vuelta rapida", biblio1, editorial3, categoria3);
        deporte1.addAutores(new Autor("Carlos", "Ruggeri", deporte1));
        deporte2.addAutores(new Autor("Jorge", "Rojas", deporte2));

           
        System.out.println(deporte1.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < deporte1.getAutores().size(); i++) {
            System.out.println("Nombre: " + deporte1.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + deporte1.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");
        
        System.out.println(deporte2.toString());
        System.out.println("Autor/Autores");
        for (int i = 0; i < deporte2.getAutores().size(); i++) {
            System.out.println("Nombre: " + deporte2.getAutores().get(i).getNombre());
            System.out.println("Apellido: " + deporte2.getAutores().get(i).getApellido());
        }
        System.out.println("------------------------------");
    }

}
