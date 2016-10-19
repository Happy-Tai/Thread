//Tickets
class Tickets{
	public static int nums=5;
	public Tickets(int nums){
		this.nums=nums;
	}
}

//�߳�1
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
//�߳�3
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

//�߳�2
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
			t1.join();    //�ȴ����߳���ֹ
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
 * ʵ��Runnable�ӿڱȼ̳�Thread�������е����ƣ�
1�����ʺ϶����ͬ�ĳ��������߳�ȥ���� ͬһ����Դ
2�������Ա���java�еĵ��̳е�����
3�������ӳ���Ľ�׳�ԣ�������Ա�����̹߳�����������ݶ���

����һ�´�ң�main������ʵҲ��һ���̡߳���java�����Ե��̶߳���ͬʱ�����ģ�
����ʲôʱ���ĸ���ִ�У���ȫ��˭�ȵõ�CPU����Դ��
 
��java�У�ÿ�γ���������������2���̡߳�һ����main�̣߳�һ���������ռ��̡߳�
��Ϊÿ��ʹ��java����ִ��һ�����ʱ��ʵ���϶�������һ���ʣ֣ͣ�ÿһ����֣�ʵϰ�ھ����ڲ���ϵͳ��������һ�����̡�

*	��sleep(long millis): ��ָ���ĺ��������õ�ǰ����ִ�е��߳����ߣ���ִͣ�У�  
*						 ����ִ��sleep()���߳���ָ����ʱ���ڿ϶����ᱻִ�У�
	��join():ָ�ȴ�t�߳���ֹ�����ȴ����߳���ֹ����������Ҫ���ľ��Ǹ��߳���ָ�����̵߳ȴ����̵߳���ֹ��
	��yield():��ͣ��ǰ����ִ�е��̶߳��󣬲�ִ�������̡߳�ʹ��yield()��Ŀ��������ͬ���ȼ����߳�֮�����ʵ�����תִ�С�
			   ����ִ��yield()���߳��п����ڽ��뵽��ִ��״̬�������ֱ�ִ�С�
	��setPriority(): �����̵߳����ȼ���
	��interrupt():�ж�ĳ���̣߳����ֽ�����ʽ�Ƚϴֱ����ᵼ����Դ�޷��ر�
	��wait() Obj.wait()����Obj.notify()����Ҫ��synchronized(Obj)һ��ʹ��
			Thread.sleep()��Object.wait()���߶�������ͣ��ǰ�̣߳��ͷ�CPU����Ȩ��
			��Ҫ����������Object.wait()���ͷ�CPUͬʱ���ͷ��˶������Ŀ��ơ�
*
**/
