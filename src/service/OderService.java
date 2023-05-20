package service;

import dao.OderDao;
import entity.Oder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OderService {
    private List<Oder> oders;
    OderDao oderDao = new OderDao();

    public OderService() {
        this.oders = oderDao.getAllOder();
    }

    public void add(Oder oder) {
        oderDao.create(oder);
        this.oders = oderDao.getAllOder();
        StaticVariable.oderId = oders.get(oders.size()-1).getId();
    }

    public List<Oder> findByName(String name) {
        List<Oder> oderList = new ArrayList<>();
        for (Oder o:oders) {
            if (o.getCustomer().getName().contains(name)){
                oderList.add(o);
            }
        }
        return oderList;
    }

    public void sortByDate(){
        Collections.sort(oders);
    }

    public void edit(Oder oder) {
        oderDao.edit(oder);
        this.oders = oderDao.getAllOder();
    }

    public void delete(int id) {
        oderDao.delete(id);
        this.oders = oderDao.getAllOder();
    }

    public List<Oder> getOders() {
        return oders;
    }
}
