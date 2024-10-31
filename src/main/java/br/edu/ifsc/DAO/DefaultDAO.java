package br.edu.ifsc.DAO;

import br.edu.ifsc.IEntidade;

import java.util.ArrayList;

public abstract class DefaultDAO<E extends IEntidade> {

    private ArrayList<E> list = new ArrayList<E>();

    public E save(E e){
        e.setId(newId());
        list.add(e);
        return e;
    }

    public void show(){
        for(E e: list){
            System.out.println(e);
        }
    }

    public void remove(E e){
        list.remove(e);
    }

    public ArrayList<E> getAllList() {
        return list;
    }

    public E getById(int id) {
        return list.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Integer newId(){
        return list.stream().mapToInt(e -> e.getId() + 1).max().orElse(0);
    }

}
