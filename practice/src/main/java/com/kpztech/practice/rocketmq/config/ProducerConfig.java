package com.kpztech.practice.rocketmq.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;

//@Configuration
public class ProducerConfig {

  /**
   * ClusterName:DefaultCluster
   * Topic:topic-test
   * 新增topic命令：sh mqadmin updateTopic -t topic-test -c DefaultCluster
   * 查看broker状态：sh mqadmin brokerStatus -c DefaultCluster
   *
   */

  @Bean
  public DefaultMQProducer producer() throws MQClientException {
    DefaultMQProducer producer = new DefaultMQProducer("Test-group");
    producer.setNamesrvAddr("127.0.0.1:9876");
    producer.setInstanceName("practice-provider");
    producer.start();
    return producer;
  }

}
