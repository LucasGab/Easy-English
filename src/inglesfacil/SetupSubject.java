/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inglesfacil;

import javafx.scene.image.Image;

/**
 * Create a subject and fill it with word(english)-word(portuguese) and link
 * word(english) with an image representation to be added to a dictionary.
 *
 * @author
 */
public class SetupSubject {

    /** stores which category the subject is from */
    private static String category;

    public static void setCategory(String s) {
        category = s;
    }

    /**
     * Fill the subject with words and images
     * @param sub Indicates which subject will be created
     * @return the subject filled with its content
     */
    public static Subject fillSubject(String sub) {
        Subject subject = new Subject();
        if (category.equals("Animais")) {
            if (sub.equals("Mamíferos")) {
                subject.setName("Dog", "Cachorro");
                subject.setImage("Dog", new Image("/resources/animals/mamiferos/dog.png"));
                subject.setName("Cat", "Gato");
                subject.setImage("Cat", new Image("/resources/animals/mamiferos/cat.png"));
                subject.setName("Horse", "Cavalo");
                subject.setImage("Horse", new Image("/resources/animals/mamiferos/horse.png"));
                subject.setName("Monkey", "Macaco");
                subject.setImage("Monkey", new Image("/resources/animals/mamiferos/monkey.png"));
            } else if (sub.equals("Aquáticos")) {
                subject.setName("Octopus", "Polvo");
                subject.setImage("Octopus", new Image("/resources/animals/aquaticos/octopus.png"));
                subject.setName("Whale", "Baleia");
                subject.setImage("Whale", new Image("/resources/animals/aquaticos/whale.png"));
                subject.setName("Shark", "Tubarão");
                subject.setImage("Shark", new Image("/resources/animals/aquaticos/shark.png"));
                subject.setName("Fish", "Peixe");
                subject.setImage("Fish", new Image("/resources/animals/aquaticos/fish.png"));
            } else if (sub.equals("Selvagens")) {
                subject.setName("Lion", "Leão");
                subject.setImage("Lion", new Image("/resources/animals/selvagens/lion.png"));
                subject.setName("Tiger", "Tigre");
                subject.setImage("Tiger", new Image("/resources/animals/selvagens/tiger.png"));
                subject.setName("Elephant", "Elefante");
                subject.setImage("Elephant", new Image("/resources/animals/selvagens/elephant.png"));
                subject.setName("Bear", "Urso");
                subject.setImage("Bear", new Image("/resources/animals/selvagens/bear.png"));
            }
        }else if(category.equals("Cores")) {
            if (sub.equals("Cores 1")) {
                subject.setName("Blue", "Azul");
                subject.setImage("Blue", new Image("/resources/color/blue.png"));
                subject.setName("Red", "Vermelho");
                subject.setImage("Red", new Image("/resources/color/red.png"));
                subject.setName("Green", "Verde");
                subject.setImage("Green", new Image("/resources/color/green.png"));
                subject.setName("Yellow", "Amarelo");
                subject.setImage("Yellow", new Image("/resources/color/yellow.png"));
            } else if (sub.equals("Cores 2")) {
                subject.setName("Black", "Preto");
                subject.setImage("Black", new Image("/resources/color/black.png"));
                subject.setName("White", "Branco");
                subject.setImage("White", new Image("/resources/color/white.png"));
                subject.setName("Pink", "Rosa");
                subject.setImage("Pink", new Image("/resources/color/pink.jpg"));
                subject.setName("Purple", "Roxo");
                subject.setImage("Purple", new Image("/resources/color/purple.png"));
            } else if (sub.equals("Cores 3")) {
                subject.setName("Brown", "Marron");
                subject.setImage("Brown", new Image("/resources/color/brown.jpg"));
                subject.setName("Grey", "Cinza");
                subject.setImage("Grey", new Image("/resources/color/grey.jpg"));
                subject.setName("Orange", "Laranja");
                subject.setImage("Orange", new Image("/resources/color/orange.jpg"));
            }
        }else if(category.equals("Objetos")) {
            if (sub.equals("Escola")) {
                subject.setName("Pen", "Caneta");
                subject.setImage("Pen", new Image("/resources/object/escola/pen.png"));
                subject.setName("Pencil", "Lápis");
                subject.setImage("Pencil", new Image("/resources/object/escola/pencil.png"));
                subject.setName("Book", "Livro");
                subject.setImage("Book", new Image("/resources/object/escola/book.gif"));
                subject.setName("Notebook", "Caderno");
                subject.setImage("Notebook", new Image("/resources/object/escola/notebook.png"));
            } else if (sub.equals("Tecnologia")) {
                subject.setName("Mouse", "Mouse");
                subject.setImage("Mouse", new Image("/resources/object/tecnologia/mouse.jpg"));
                subject.setName("Keyboard", "Teclado");
                subject.setImage("Keyboard", new Image("/resources/object/tecnologia/keyboard.png"));
                subject.setName("Cellphone", "Celular");
                subject.setImage("Cellphone", new Image("/resources/object/tecnologia/cellphone.png"));
                subject.setName("Computer", "Computador");
                subject.setImage("Computer", new Image("/resources/object/tecnologia/computer.gif"));
            } else if (sub.equals("Móveis")) {
                subject.setName("Chair", "Cadeira");
                subject.setImage("Chair", new Image("/resources/object/moveis/chair.png"));
                subject.setName("Desk", "Mesa");
                subject.setImage("Desk", new Image("/resources/object/moveis/desk.png"));
                subject.setName("Bed", "Cama");
                subject.setImage("Bed", new Image("/resources/object/moveis/bed.png"));
                subject.setName("Couch", "Sofá");
                subject.setImage("Couch", new Image("/resources/object/moveis/couch.png"));
            }else if (sub.equals("Cozinha")) {
                subject.setName("Knife", "faca");
                subject.setImage("Knife", new Image("/resources/object/cozinha/knife.png"));
                subject.setName("Fork", "Garfo");
                subject.setImage("Fork", new Image("/resources/object/cozinha/fork.png"));
                subject.setName("Spoon", "Colher");
                subject.setImage("Spoon", new Image("/resources/object/cozinha/spoon.png"));
                subject.setName("Plate", "Prato");
                subject.setImage("Plate", new Image("/resources/object/cozinha/plate.png"));
                subject.setName("Kitchen", "Cozinha");
                subject.setImage("Kitchen", new Image("/resources/object/cozinha/kitchen.png"));
            }
        }
        return subject;
    }
}
