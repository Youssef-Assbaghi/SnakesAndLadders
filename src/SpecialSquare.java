package seconddesign;

public final class SpecialSquare extends SquareRole {

  private int transport;
  protected int tipo; //0 Serpiente 1 Escalera
  String[] Casillas = {"Snakes", "Ladder","Death"};
  public SpecialSquare(Square s, int t,int type) {

    super(s);
    tipo=type;
    if(tipo==0){
      assert t<0 : "A snake shift must be negative" ;
      transport = t;
    }else if(tipo==1){
      assert t>0 : "A ladder shift must be positive";
      transport = t;
    }else{
      transport=t;
    }

  }


  @Override
  public int getTypo(){
    return tipo;
  }
  public Square landHereOrGoHome() {

      System.out.println(Casillas[tipo]+" from " + (square.getPosition()+1) + " to "
          + (destination().getPosition()+1));
      if (tipo==2){
       // square.getPlayer().setAlive(false);
        //Player p=square.getPlayer();
        return square;
      }else{
        return destination().landHereOrGoHome();
      }

  }

  private Square destination() {
    if (tipo==2){
      //square.getPlayer().setAlive(false);
      return square;
    }
    return square.findRelativeSquare(transport);
  }
}
