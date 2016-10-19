//Tickets
class Tickets{
	public static int nums=5;
	public Tickets(int nums){
		this.nums=nums;
	}
}

//线程1
class Thread1 extends Thread{
	private int count=5;
	private String name="";
	
	public Thread1(String name){
		this.name=name;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(name+"-Run count= "+count--);
			try {
				sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
//线程3
class Thread3 implements Runnable{
	private int count=5;
	private String name="";
	
	public Thread3(String name){
		this.name=name;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(name+"-Run count= "+count--);
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

//线程2
class Thread2 implements Runnable{
	private int count=5;
	private String name="";
	
	public Thread2(String name){
		this.name=name;
	}
	
	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(name+"-Run count= "+count--);
			try {
				Thread.sleep((int)Math.random()*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class Solution {
	public static void main(String[] args) {
		
//		int tickets=new Tickets(5).nums;
		/**
		 * Thread test 1*/
		Thread1 t1=new Thread1("A");
		t1.start();
		try {
			t1.join();    //等待该线程终止
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new Thread(new Thread2("B")).start();
		new Thread(new Thread3("C")).start();
		
		
		/**
		 * Thread test 2*/
//		ThreadUtils a=new ThreadUtils();
//		new Thread(a).start();
//		System.out.println("i= "+a.i);
//		
//		a.run();
//
//		int j=a.i;
//		System.out.println("j= "+j);
	}

}
/**
 * 实现Runnable接口比继承Thread类所具有的优势：
1）：适合多个相同的程序代码的线程去处理 同一个资源
2）：可以避免java中的单继承的限制
3）：增加程序的健壮性，代码可以被多个线程共享，代码和数据独立

提醒一下大家：main方法其实也是一个线程。在java中所以的线程都是同时启动的，
至于什么时候，哪个先执行，完全看谁先得到CPU的资源。
 
在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。
因为每当使用java命令执行一个类的时候，实际上都会启动一个ＪＶＭ，每一个ｊＶＭ实习在就是在操作系统中启动了一个进程。

*	①sleep(long millis): 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）  
*						 所以执行sleep()的线程在指定的时间内肯定不会被执行；
	②join():指等待t线程终止。“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
	③yield():暂停当前正在执行的线程对象，并执行其他线程。使用yield()的目的是让相同优先级的线程之间能适当的轮转执行。
			   所以执行yield()的线程有可能在进入到可执行状态后马上又被执行。
	④setPriority(): 更改线程的优先级。
	⑤interrupt():中断某个线程，这种结束方式比较粗暴，会导致资源无法关闭
	⑥wait() Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用
			Thread.sleep()与Object.wait()二者都可以暂停当前线程，释放CPU控制权，
			主要的区别在于Object.wait()在释放CPU同时，释放了对象锁的控制。
*
**/
