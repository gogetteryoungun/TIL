## Multithreading

* **1** thread is **1** flow of code running.
 Therefore, 1 process with 2 threads has 2 flows of code running.

> Multiprocessing is multitasking on an application level
  Multithreading is multitasking inside of a process
  A process can use either single-threading or multithreading.

* Processes are independent of each other for errors.
  An error occurred in a process doesn't affect another.
* Since threads are created by a process, when an error occurs in one  process, it often affects another. Therefore, high caution for exception handling is needed.

* With a single-threading app, when the main thread finishes, processes finish too, but with a multithreading app, if there is at least one thread still running, the process doesn't finish until it does.

### 1. Using Runnable to create a thread

When creating a thread instance directly from java.lang.Thread class, we need to call a constructor with a Runnable Object as parameter.

``` Java
class Task implements Runnable{
  public void run(){
    // code...
  }
}  
```

Runnable is an object containing code for a task, not the actual Thread.
A thread is created like this.

``` java
Runnable task = new Task();
Thread thread = new Thread(task);
//OR

Thread thread = new Thread(new Runnable(){
  public void run(){
    //code...
  }
});

```

### 2. Defining a task thread as a child class of Thread

``` java

public class WorkThread extends Thread{
  public void run(){
    //code...
  }
}

Thread thread = new WorkThread();
```



### Concurrency vs Parallelism

* In Concurrency, multiple threads run on 1 core **taking turns**.
  run() in each thread is executed little by little in a short span of time, taking turns. -> Scheduling is important
* In Parallelism, there are multiple cores, and each one of them run each thread **at the same time**.

If (num of threads > num of cores), Thread Scheduling is paramount in order to decide in what order threads are to be run.

### Scheduling

#### 1. Priority
The thread with a higher priority (MAX 10) is considered to be run first. We can set the priority with code.
* Default priority is 5, with 1 the lowest.
* Thread.setPriority() is used.
> With QuadCores, priority comes into play when there are more than 5 threads.

#### Example 1

```java
//Main
public class PriorityExample {

	public static void main(String[] args) {

		for(int i=1; i<11; i++){
		Thread thread = new CalThread("Thread" +i);
    //creates 10 threads
		if(i!=10){
			thread.setPriority(Thread.MIN_PRIORITY);
		}else{
			thread.setPriority(Thread.MAX_PRIORITY);
		}
		thread.start();
		}
  }  
}

//Thread
public class CalThread extends Thread {

	public CalThread(String name){
		setName(name);
		// no need to use Thread.getName() because this class extends Thread
		//therefore all methods in Thread are overridden
	}

	public void run(){
		try{
		Thread.sleep(2000);
		}catch(InterruptedException e){}

		System.out.println(getName());

	}
}
```


#### Example 2

``` java

public class MainThreadExample {

	public static void main(String[] args) {
		Calculator calculator= new Calculator();
		User1 user1 = new User1(calculator);
		user1.start();

		User2 user2 = new User2(calculator);
		user2.start();
	}

}


public class Calculator {

	private int memory;

	public void setMemory(int memory){
		this.memory = memory;

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}

		System.out.println(Thread.currentThread().getName()+ ": "+ this.memory);
	}
}


public class User1 extends Thread{

	private Calculator calculator;

	public User1(Calculator calculator){
		this.calculator = calculator;
		this.setName("User1");

	}

	public void run(){
		calculator.setMemory(100);
	}

}


public class User2 extends Thread{

	private Calculator calculator;

	public User2(Calculator calculator){
		this.calculator = calculator;
		this.setName("User2");

	}

	public void run(){
		calculator.setMemory(50);
	}

}
```

When executed:
User1:50
User2:50

 because after User1 thread sets memory to 100, it sleeps for 2 secs, then within this 2 secs, User2 thread sets memory to 50 then sleeps again. After the first 2s, when User1 prints memory, it's 50 because User2 set it to 50, then User2 prints memory which is 50 again.

> This is like sharing a calculator. While one goes to the toilet, another comes and uses the calculator -> disaster

### Critical Section

Java provides **synchronized** for Critical Section which is a section of code where only 1 thread can access at a time.

When a thread accesses a synchronized block, it locks the object so that no other thread can access the critical section while it's running that bit.

* The keyword synchronized can be attached either to an instance or a static method.

```java
public synchronized void method(){
  // code...
}

public void method(){
  // the bit where multiple threads can run
  synchronized(sharing threads){
    // CRITICAL SECTION
  }
  // the bit where multiple threads can run
}
```
When there are multiple synchronized methods and synchronized blocks, when one of the threads is accessing one of them, none of the other threads can access any of the synchronized ones.

Example 2 is edited with synchronized in the following code.

```java


public class Calculator {

	private int memory;

	public synchronized void setMemory(int memory){
		this.memory = memory;

		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){}

		System.out.println(Thread.currentThread().getName()+ ": "+ this.memory);
	}
}
```

Now the result is:

User1: 100
User2: 50


It's because User 2 is not allowed to access the critical section (setMemory()) unless User1 is done with this bit. Therefore, User2 can't creep in during the 2 s, User1's setMemory() is sleeping. HAHA! Once User1 is done, User2 can mind its business then, printing 50 for memory.
