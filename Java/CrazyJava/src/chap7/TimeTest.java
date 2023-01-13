package chap7;

import java.time.*;

public class TimeTest {
	public static void main(String[] args) {
		// Clock
		Clock c = Clock.systemUTC();
		System.out.println(c.instant()); // 获取当前时间
		System.out.println(c.millis()); // 获取对应毫秒

		// Duration 用于获取持续时间
		Duration d = Duration.ofSeconds(6000);
		System.out.println(d.toHours()); // 时间转换

		Clock c2 = Clock.offset(c,d);
		System.out.println(c2.instant());

		// Instant 获取当前时间
		Instant instant = Instant.now();
		System.out.println(instant);

		// LocalDate
		LocalDate ld = LocalDate.now();
		System.out.println(ld);

		LocalTime lt = LocalTime.now();
		System.out.println(lt);

		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
	}
}
