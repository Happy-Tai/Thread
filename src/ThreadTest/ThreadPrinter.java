package ThreadTest;
/**
 * һ���ȽϾ���������⣬��ĿҪ�����£�
    ���������̣߳�A�̴߳�ӡ10��A��B�̴߳�ӡ10��B,C�̴߳�ӡ10��C��
    Ҫ���߳�ͬʱ���У������ӡ10��ABC�����������Object��wait()��notify()�Ϳ��Ժܷ���Ľ����
    wait(): ǿ��һ���̵߳ȴ��� 
����notify(): ֪ͨһ���̼߳������С�*/
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
					
					self.notify();//�ͷŶ�����
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
			ta.sleep(100);    //ͨ����ȡsleep()��������֤A B C �߳�һ�ο�����
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
