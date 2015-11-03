package common.H4Q;

import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.sikuli.api.robot.Key;
import org.sikuli.script.Screen;

public class Teclas {
	
	public static void Enter(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.ENTER);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla ENTER");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Enter() throws Exception{
		Enter(3);
	}
	
	public static void Ctrl(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.CTRL);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla CTRL");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Ctrl() throws Exception{
		Ctrl(3);
	}
	
	public static void Shift(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.SHIFT);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla SHIFT");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Shift() throws Exception{
		Shift(3);
	}

	
	public static void Tab(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.TAB);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla TAB");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Tab() throws Exception{
		Tab(3);
	}
	
	public static void Esc(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.ESC);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla ESC");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Esc() throws Exception{
		Esc(3);
	}
	
	public static void Insert(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.INSERT);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla INSERT");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Insert() throws Exception{
		Insert(3);
	}
	
	public static void Pause(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.PAUSE);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla PAUSE");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Pause() throws Exception{
		Pause(3);
	}
	
	public static void Delete(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.DELETE);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla PAUSE");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Delete() throws Exception{
		Delete(3);
	}
	
	public static void F1(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F1);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F1");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F1() throws Exception{
		F1(3);
	}
	
	public static void F2(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F2);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F2");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F2() throws Exception{
		F2(3);
	}
	
	public static void F3(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F3);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F3");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F3() throws Exception{
		F3(3);
	}
	
	public static void F4(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F4);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F4");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F4() throws Exception{
		F4(3);
	}
	
	public static void F5(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F5);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F5");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F5() throws Exception{
		F5(3);
	}
	
	public static void F6(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F6);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F6");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F6() throws Exception{
		F6(3);
	}
	
	public static void F7(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F7);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F7");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F7() throws Exception{
		F7(3);
	}
	
	public static void F8(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F8);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F8");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F8() throws Exception{
		F8(3);
	}
	
	public static void F9(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F9);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F9");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F9() throws Exception{
		F9(3);
	}
	
	public static void F10(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F10);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F10");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F10() throws Exception{
		F10(3);
	}
	
	public static void F11(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F11);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F11");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F11() throws Exception{
		F11(3);
	}
	
	public static void F12(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.F12);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla F12");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void F12() throws Exception{
		F12(3);
	}
	
	public static void Izquierda(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.LEFT);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla LEFT");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Izquierda() throws Exception{
		Izquierda(3);
	}
	
	public static void Derecha(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.RIGHT);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla RIGTH");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Derecha() throws Exception{
		Derecha(3);
	}
	
	public static void Arriba(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.UP);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla UP");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Arriba() throws Exception{
		Arriba(3);
	}
	
	public static void Abajo(int tiempo) throws Exception{
		Screen s = new Screen();
		for (int i=0; i<=tiempo*10; i++){
			try{
				Thread.sleep(100);
				s.type(Key.DOWN);
				break;
			}
			catch(Exception e){
				if(i==tiempo*10){
					if (e instanceof NoSuchElementException)
						fail("No es posible presionar la tecla DOWN");
					else 
						throw e;
				}
			}
		}
	}
	
	public static void Abajo() throws Exception{
		Abajo(3);
	}
	

}