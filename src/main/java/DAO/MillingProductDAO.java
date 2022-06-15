package DAO;

import Model.MillingProduct;

public interface MillingProductDAO {

    MillingProduct get();
    Boolean update(MillingProduct millingProduct);

}
