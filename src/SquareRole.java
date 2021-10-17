package seconddesign;

import java.util.LinkedList;


public abstract class SquareRole {

	/**
	 * c@uml.property  name="square"
	 * @uml.associationEnd  multiplicity="(1 1)" inverse="squareRole:problemDomain.Square"
	 */
	protected Square square = null;

	public SquareRole(Square s) {
		assert s!=null : "Null square for square role";
		square = s;
	}

	public boolean isOccupied() {
		return square.getPlayer() != null;
	}
	
	public boolean isFirstSquare() {
		return false;
	}

	public boolean isLastSquare() {
		return false;
	}

	public Square moveAndLand(int moves) {
		int lastPosition = square.findLastSquare().getPosition();
		int presentPosition = square.getPosition();
		if (presentPosition+moves>lastPosition) {
			System.out.println("Should go to " + (presentPosition+moves+1) 
					+ " beyond last square " + (lastPosition+1) 
					+ " so don't move");
			int marcha_atras=lastPosition-(presentPosition+moves);
			int sauare_objetivo=lastPosition+marcha_atras;
			int movimiento=sauare_objetivo-presentPosition;

			return square.findRelativeSquare(movimiento).landHereOrGoHome();
		} else {
			System.out.println("move from " + (square.getPosition()+1) + " to "
					+ (square.findRelativeSquare(moves).getPosition()+1));
			return square.findRelativeSquare(moves).landHereOrGoHome();
		}
	}


	/**
	 *
	 * @return MIRAR AQUI
	 *
	 */
	public int getTypo(){return 0;}
	public Square landHereOrGoHome() {
		if (square.isOccupied()) {
			System.out.println("square " + (square.getPosition()+1) + " is occupied");
		} else {
			System.out.println("land at " + (square.getPosition()+1));
		}
		//Player p=square.getPlayer();
		return square.isOccupied() ? square.findFirstSquare() : square;
	}

	public void enter(Player player) {
		int i=this.getTypo();
		if (i==2) {
			player.setAlive(false);
			leave(player);
			player=null;
		}else	{
			square.setPlayer(player);
			player.setSquare(square);
		}




	}

	public void leave(Player player) {
		square.setPlayer(null);
	}
}
