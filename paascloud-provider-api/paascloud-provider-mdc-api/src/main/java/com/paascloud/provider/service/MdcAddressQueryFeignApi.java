package com.paascloud.provider.service;

import com.paascloud.provider.model.dto.AddressDTO;
import com.paascloud.provider.service.hystrix.MdcAddressQueryFeignHystrix;
import com.passcloud.common.util.wrapper.Wrapper;
import com.passcloud.security.feign.OAuth2FeignAutoConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Mdc product query feign api.
 *
 * @author liyuzhang
 */
@FeignClient(value = "paascloud-provider-mdc", configuration = OAuth2FeignAutoConfiguration.class, fallback = MdcAddressQueryFeignHystrix.class)
public interface MdcAddressQueryFeignApi {

	/**
	 * Select by id wrapper.
	 *
	 * @param addressId the address id
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/api/address/getById/{addressId}")
	Wrapper<AddressDTO> getById(@PathVariable("addressId") Long addressId);
}
