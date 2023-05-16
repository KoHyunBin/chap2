package gdu.kr.chap2.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import gdu.kr.chap2.Executor;
import gdu.kr.chap2.HomeController;
import gdu.kr.chap2.InfraredRaySensor;
import gdu.kr.chap2.WorkUnit;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Executor exec = ctx.getBean("executor",Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		HomeController home = ctx.getBean("homeController",HomeController.class);
		home.checkSensorAndAlarm();
		System.out.println("=========== 창문에 침입자 발견 =============");
		InfraredRaySensor sensor = ctx.getBean("windowSensor",InfraredRaySensor.class);
		sensor.foundObject();
		home.checkSensorAndAlarm();
		System.out.println("=========== 현관에 침입자 발견 ============");
		sensor = ctx.getBean("doorSensor",InfraredRaySensor.class);
		sensor.foundObject();
		home.checkSensorAndAlarm();
		System.out.println("============ 전등에 침입자 발견 ============");
		sensor = ctx.getBean("lapmSensor",InfraredRaySensor.class);
		sensor.foundObject();
		home.checkSensorAndAlarm();
	}

}
