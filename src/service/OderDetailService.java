package service;

import dao.OderDetailDao;
import entity.OderDetail;

import java.util.List;

public class OderDetailService {
    OderDetailDao oderDetailDao = new OderDetailDao();

    public OderDetailService() {
    }

    public void add(OderDetail oderDetail) {
        oderDetailDao.create(oderDetail,  StaticVariable.oderId, oderDetail.getProduct().getId());
    }

    public void edit(OderDetail oderDetail, int idOder){
        oderDetailDao.edit(oderDetail,oderDetail.getOder().getId(),oderDetail.getProduct().getId());
    }

    public void delete(int id){
        oderDetailDao.delete(id);
    }

    public List<OderDetail> getOderDetailByOder(int idOder) {
        return oderDetailDao.getAllOderByOder(idOder);
    }
    public OderDetail getOderDetailById(int id) {
        return oderDetailDao.getOderById(id);
    }
}
