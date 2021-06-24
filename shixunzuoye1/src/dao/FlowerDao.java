package dao;

import java.util.List;

import entity.Flower;

public interface FlowerDao {
     abstract public boolean insert(Flower flower);
     
     abstract public List<Flower> findAll();
     
     abstract public boolean delete(int id);
}
