package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javafx.scene.Node;
import model.baseShape.BaseCircle;

public class Pizza {

    // un cercle par défaut
    private BaseShape baseShape;

    // base principale
    private Element base;

    // tout les éléments contituant la pizza
    private ArrayList<ArrayList<Element>> elements;
    
    public Pizza(){
        elements = new ArrayList<>();
    }


    public void setBase(Element base){
        Objects.requireNonNull(base);
        
        // la base principale 
        this.base = base;
    }

    public void addElement(Element element){
        Objects.requireNonNull(element);

        // ajoute n'importe quel élément sur la pizza
        
        // on ajoute la base en base principale si il n'y a rien en dessous
        if (elements.size() == 0 && element.isBase()){
            setBase(element);
        }

        if (elements.size() == 0){
            elements.add(new ArrayList<Element>(List.of(element)));
        } else {
            
            ArrayList<Element> lastElements = elements.getLast();
            // si c'est le meme élément que la dernière layer
            if (lastElements.getFirst().label().equals(element.label())){
                
                // on l'ajoute a cette liste 
                lastElements.add(element);
            } else {
                
                // sinon on créer une nouvelle liste 
                elements.add(new ArrayList<>(List.of(element)));
            }
        }
    }

    public void remove(int index){
        if (index < 0 || index > elements.size()){
            throw new IllegalArgumentException();
        }

        elements.remove(index);        
    }

    public void setBaseShape(BaseShape baseShape){
        Objects.requireNonNull(baseShape);
        this.baseShape = baseShape;
    }

    public void moveUpElement(int index){
        if (index < 0 || index > elements.size()){
            throw new IllegalArgumentException();
        }

        // les cas ou on est a la limite de la liste
        if (index == elements.size() - 1){
            return;
        }

        Collections.swap(elements, index, index + 1);        
    }

    public void moveDownElement(int index){
        if (index < 0 || index > elements.size()){
            throw new IllegalArgumentException();
        }

        // les cas ou on est a la limite de la liste
        if (index == 0){
            return;
        }

        Collections.swap(elements, index, index - 1);
    }


    public List<Node> shapes(){
        
        // on transforme l'ArrayList en List pour que le controller ne puisse pas la modifier
        ArrayList<Node> res = new ArrayList<>();

        for (var layer : elements){
            for (var element : layer){
                res.add(element.shape());
            }
        }
        return List.copyOf(res);
    }

    public Element base(){
        return base;
    }

    public boolean isBaseInFirstLayer(){
        return elements.getFirst().getFirst().isBase();
    }


}
