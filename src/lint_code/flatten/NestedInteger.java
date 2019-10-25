package lint_code.flatten;

import java.util.List;

public class NestedInteger {

    private int integer;
    private List<NestedInteger> list;

    public boolean isInteger(){
        return false;
    }

    public NestedInteger(int integer) {
        this.integer = integer;
    }

    public int getInteger() {
        return integer;
    }

    public void setInteger(int integer) {
        this.integer = integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public void setList(List<NestedInteger> list) {
        this.list = list;
    }
}

