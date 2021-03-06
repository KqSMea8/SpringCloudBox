/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springcloudbox.core.cloud.config;

import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springcloudbox.core.cloud.feign.FeignHystrixConcurrencyStrategy;
import org.springcloudbox.core.cloud.feign.ScBoxFeignRequestHeaderInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WEB配置
 *
 * @author Chill
 */
@Slf4j
@Configuration
@EnableCaching
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ScBoxFeignConfiguration implements WebMvcConfigurer {

  @Bean
  @ConditionalOnMissingBean
  public RequestInterceptor requestInterceptor() {
    return new ScBoxFeignRequestHeaderInterceptor();
  }

  @Bean
  public FeignHystrixConcurrencyStrategy feignHystrixConcurrencyStrategy() {
    return new FeignHystrixConcurrencyStrategy();
  }

}
