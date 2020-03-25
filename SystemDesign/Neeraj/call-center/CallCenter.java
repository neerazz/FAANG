import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CallCenter{
    public static void main(String[] args) {
        CallHandler callHandler = new CallHandler();
        EmployeeFactory employeeFactory = new EmployeeFactory();
        List<Employee> employees = new ArrayList<>();
        employees.add(employeeFactory.createEmployee(EmpType.Operator,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Operator,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Manager,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Operator,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Operator,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Manager,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Operator,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Manager,callHandler));
        employees.add(employeeFactory.createEmployee(EmpType.Director,callHandler));
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Call call = new Call();
                call.received = LocalDateTime.now();
                callHandler.handleCall(call);
                System.out.println("Adding a Call");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        AtomicInteger counter = new AtomicInteger();
        Thread t2 = new Thread(() -> {
            while (true){
                if(callHandler.havePendingCalls()){
                    counter.set(0);
                    for(Employee emp : employees){
                        emp.getNextCall();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    counter.getAndIncrement();
                    Thread.sleep(500);
                    if(counter.intValue() > 10){
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
class EmployeeFactory{
    public Employee createEmployee(EmpType type, CallHandler callHandler){
        if(type.equals(EmpType.Operator)){
            return new Operator(callHandler);
        }else if(type.equals(EmpType.Manager)){
            return new Manager(callHandler);
        }else{
            return new Director(callHandler);
        }
    }
}
class CallHandler{
    Queue<Call> operatorCall = new LinkedList<>();
    Queue<Call> managerCall = new LinkedList<>();
    Queue<Call> directorCall = new LinkedList<>();
    public void handleCall(Call call){
        System.out.println(" operatorCall = " + operatorCall);
        System.out.println(" managerCall = " + managerCall);
        System.out.println(" directorCall = " + directorCall);
        if (call.type.equals(EmpType.Operator)){
            operatorCall.add(call);
        }else if (call.type.equals(EmpType.Manager)){
            managerCall.add(call);
        }else if (call.type.equals(EmpType.Director)){
            directorCall.add(call);
        }else{
            throw new RuntimeException("The Call type is invalid");
        }
    }
    public boolean havePendingCalls(){
        return !operatorCall.isEmpty() || !managerCall.isEmpty() || !directorCall.isEmpty();
    }
    public Call getNextCall(EmpType type){
        if (type.equals(EmpType.Operator)){
            return operatorCall.isEmpty() ? null : operatorCall.poll();
        }else if (type.equals(EmpType.Manager)){
            return managerCall.isEmpty() ? null : managerCall.poll();
        }else if (type.equals(EmpType.Director)){
            return directorCall.isEmpty() ? null : directorCall.poll();
        }else{
            throw new RuntimeException("The Call type is invalid");
        }
    }
}
class Call{
    EmpType type = EmpType.Operator;
    CallStatus status;
    LocalDateTime received;

    @Override
    public String toString() {
        return "Call{" +
                "type=" + type +
                ", status=" + status +
                ", received=" + received +
                '}';
    }
}
enum EmpType {
    Operator, Manager, Director;
}
enum CallStatus{
    Received, In_Progress, Ended;
}
abstract class Employee{
    CallHandler handler;
    Random random = new Random();
    Employee(CallHandler handler){
        this.handler = handler;
    }
    void takeCall(Call call){
        call.status = CallStatus.In_Progress;
        receiveCall(call);
    }

    void endCall(Call call){
        call.status = CallStatus.Ended;
        getNextCall();
    }
    abstract void receiveCall(Call call);
    abstract void getNextCall();
    abstract void escalateCall(Call call);
}

class Operator extends Employee{

    Operator(CallHandler handler) {
        super(handler);
    }

    @Override
    public void receiveCall(Call call){
        System.out.println("Operator: Receiving Call.");
        if (random.nextInt(10) % 2 == 0){
//            When even then escalate call.
            escalateCall(call);
        }else{
            endCall(call);
        }
    }

    @Override
    void getNextCall(){
        System.out.println("Operator: GetNext Call.");
        Call call = handler.getNextCall(EmpType.Operator);
        if(call == null){
            System.out.println("Operator: I am ideal.");
        }else{
            receiveCall(call);
        }
    }

    @Override
    void escalateCall(Call call){
        call.type = EmpType.Manager;
        call.status = CallStatus.Received;
        System.out.println("Operator: Escalating Call.");
        handler.handleCall(call);
    }
}

class Manager extends Employee{

    Manager(CallHandler handler){
        super(handler);
    }

    @Override
    public void receiveCall(Call call){
        System.out.println("Manager: Receiving Call.");
        if (random.nextInt(10) % 2 == 0){
//            When even then escalate call.
            escalateCall(call);
        }else{
            endCall(call);
        }
    }

    @Override
    public void getNextCall(){
        System.out.println("Manager: GetNext Call.");
        Call call = handler.getNextCall(EmpType.Manager);
        if(call == null){
            System.out.println("Manager: I am ideal.");
        }else{
            receiveCall(call);
        }
    }

    @Override
    public void escalateCall(Call call){
        call.type = EmpType.Director;
        call.status = CallStatus.Received;
        System.out.println("Manager: Escalating Call.");
        handler.handleCall(call);
    }
}

class Director extends Employee{

    Director(CallHandler handler){
        super(handler);
    }

    @Override
    public void receiveCall(Call call){
        System.out.println("Director: Receiving Call.");
        if (random.nextInt(10) % 2 == 0){
//            When even then escalate call.
            escalateCall(call);
        }else{
            endCall(call);
        }
    }

    @Override
    public void getNextCall(){
        System.out.println("Director: GetNext Call.");
        Call call = handler.getNextCall(EmpType.Director);
        if(call == null){
            System.out.println("Director: I am ideal.");
        }else{
            receiveCall(call);
        }
    }

    @Override
    public void escalateCall(Call call){
        System.out.println("Director: I can handle all Call.");
    }
}
