package entry;

import java.io.Serializable;
import java.util.List;

public class PageResult  implements Serializable {
    private int total;//总记录数
    private List rows;//每页记录

    public PageResult(int total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
