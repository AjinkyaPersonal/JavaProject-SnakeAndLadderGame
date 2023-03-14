class Coordinates {
    int rn;
    int cn;

    Coordinates(int rn , int cn){
        this.cn = cn;
        this.rn = rn;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[').append(rn).append(", ").append(cn).append(']');
        return sb.toString();
    }
}
