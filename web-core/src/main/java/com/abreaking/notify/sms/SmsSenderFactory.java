/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.abreaking.notify.sms;

import com.abreaking.model.query.OptionQuery;
import com.abreaking.common.util.StringUtils;

public class SmsSenderFactory {
	

	public static ISmsSender createSender() {
		
		String provider = OptionQuery.me().findValue("sms_app_provider");
		
		if(StringUtils.isBlank(provider)){
			return new AlidayuSmsSender();
		}
		
		else if("sms_provider_alidayu".equals(provider)){
			return new AlidayuSmsSender();
		}
		
//		其他短信服务商
//		else if("sms_provider_xxx".equals(provider)){
//			return new XXXSmsSender();
//		}
		
		return new AlidayuSmsSender();

	}

}
