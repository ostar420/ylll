
package com.ylll.core.task;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * Spring调度，指定时间执行
 * 利用了spring中使用注解的方式来进行任务调度。 
 */
@Component
@Lazy(false)
public class SpringTaskController {
	
	/**
	 * 与用户设置的使用率比较 spirng 调度
	 * corn表达式 {秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
         * "30 * * * * ?" 每半分钟触发任务
         *"30 10 * * * ?" 每小时的10分30秒触发任务
         *"30 10 1 * * ?" 每天1点10分30秒触发任务
         *"30 10 1 20 * ?" 每月20号1点10分30秒触发任务
         *"30 10 1 20 10 ? *" 每年10月20号1点10分30秒触发任务
         *"30 10 1 20 10 ? 2011" 2011年10月20号1点10分30秒触发任务
         *"30 10 1 ? 10 * 2011" 2011年10月每天1点10分30秒触发任务
         *"30 10 1 ? 10 SUN 2011" 2011年10月每周日1点10分30秒触发任务
         *"15,30,45 * * * * ?" 每15秒，30秒，45秒时触发任务
         *"15-45 * * * * ?" 15到45秒内，每秒都触发任务
         *"15/5 * * * * ?" 每分钟的每15秒开始触发，每隔5秒触发一次
         *"15-30/5 * * * * ?" 每分钟的15秒到30秒之间开始触发，每隔5秒触发一次
         *"0 0/3 * * * ?" 每小时的第0分0秒开始，每三分钟触发一次
         *"0 15 10 ? * MON-FRI" 星期一到星期五的10点15分0秒触发任务
         *"0 15 10 L * ?" 每个月最后一天的10点15分0秒触发任务
         *"0 15 10 LW * ?" 每个月最后一个工作日的10点15分0秒触发任务
         *"0 15 10 ? * 5L" 每个月最后一个星期四的10点15分0秒触发任务
         *"0 15 10 ? * 5#3" 每个月第三周的星期四的10点15分0秒触发任务
	 * @throws Exception
	 */
	@Scheduled(cron = "1 * *  * * ? ")
	public void task() throws Exception {
		// do somethings
            
            System.out.println("this is my task..............");
	}
}