package ThreadTest;
/**
 * 一道比较经典的面试题，题目要求如下：
    建立三个线程，A线程打印10次A，B线程打印10次B,C线程打印10次C，
    要求线程同时运行，交替打印10次ABC。这个问题用Object的wait()，notify()就可以很方便的解决。
    wait(): 强迫一个线程等待。 
　　notify(): 通知一个线程继续运行。*/
class ThreadPrinter implements Runnable{
	private String name;
	private Object prev;
	private Object self;
	
	public ThreadPrinter(String name,Object prev,Object self) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.prev=prev;
		this.self=self;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int count=10;
		while(count>0){
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			synchronized (prev){
				synchronized(self){
					System.out.print(name);
					count--;
					
					self.notify();//释放对象锁
				}
				
				try {
					prev.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			

		}
		

	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n=10;
		Object a=new Object();
		Object b=new Object();
		Object c=new Object();
		
		Thread ta=new Thread(new ThreadPrinter("A",c,a));
		Thread tb=new Thread(new ThreadPrinter("B",a,b));
		Thread tc=new Thread(new ThreadPrinter("C",b,c));
		
		ta.start();
		try {
			ta.sleep(100);    //通过采取sleep()方法，保证A B C 线程一次开启。
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tb.start();
		try {
			ta.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tc.start();
		try {
			ta.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
