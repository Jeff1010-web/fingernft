package com.fingerchar.api.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fingerchar.api.utils.DappWeb3jUtil;
import com.fingerchar.core.base.service.IBaseService;
import com.fingerchar.db.base.BaseEntity;
import com.fingerchar.db.dao.ext.FcContractExtMapper;
import com.fingerchar.db.domain.FcContract;

@Service
public class FcContractService {

	@Autowired
	FcContractExtMapper contractExtMapper;
	
	@Autowired
	IBaseService baseService;
	
	/**
	 * 根据合约地址获取合约信息
	 * @param address
	 * @return
	 */
	public FcContract getByAddress(String address) {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.ADDRESS, address).eq(BaseEntity.DELETED, false);
		return this.baseService.getByCondition(FcContract.class, wrapper);
	}
	
	public FcContract getInfo(String address) {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.ADDRESS, address).eq(BaseEntity.DELETED, false);
		FcContract contract = this.baseService.getByCondition(FcContract.class, wrapper);
		if(null != contract && (StringUtils.isEmpty(contract.getSymbol()) || StringUtils.isEmpty(contract.getName())) && contract.getGetInfoTimes() < 13) {
			UpdateWrapper<FcContract> uwrapper = new UpdateWrapper<>();
			if(StringUtils.isEmpty(contract.getSymbol())) {
				String symbol = DappWeb3jUtil.getSymbol(contract.getAddress());
				contract.setSymbol(symbol);
				uwrapper.set(FcContract.SYMBOL, symbol);
			}
			if(StringUtils.isEmpty(contract.getName())) {
				String name = DappWeb3jUtil.getName(contract.getAddress());
				contract.setName(name);
				uwrapper.set(FcContract.NAME, name);
			}
			uwrapper.setSql(FcContract.GET_INFO_TIMES + " = " + FcContract.GET_INFO_TIMES + " + 1");
			uwrapper.eq(BaseEntity.ID, contract.getId());
			this.baseService.updateByCondition(FcContract.class, uwrapper);
		}
		return contract;
	}

	/**
	 * 返回所有合约
	 * @return
	 */
	public List<FcContract> findAll() {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(BaseEntity.DELETED, false).eq(FcContract.IS_ADMIN, true);
		return this.baseService.findByCondition(FcContract.class, wrapper);
	}

	public Integer save(FcContract contract) {
		return this.baseService.save(contract);
	}

	public List<FcContract> findByUserAddress(String address) {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.OWNER, address).eq(BaseEntity.DELETED, false);
		wrapper.or(i -> i.eq(FcContract.IS_ADMIN, true).eq(BaseEntity.DELETED, false));
		return this.baseService.findByCondition(FcContract.class, wrapper);
	}
	
	public List<FcContract> findSystemContract() {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.IS_ADMIN, true).eq(BaseEntity.DELETED, false);
		return this.baseService.findByCondition(FcContract.class, wrapper);
	}

	public FcContract findById(Long id) {
		return this.baseService.getById(FcContract.class, id);
	}

	public  List<FcContract> findBySymbol(String symbol){
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.SYMBOL, symbol).eq(BaseEntity.DELETED, false);
		return this.baseService.findByCondition(FcContract.class, wrapper);
	}


	@Transactional(rollbackFor = Exception.class)
	public String getTokenId(String address) {
		String tokenId = this.contractExtMapper.getContractWithLock(address);
		if(null == tokenId) {
			tokenId = "1";
		} else {
			tokenId = new BigInteger(tokenId).add(BigInteger.ONE).toString();
		}
		this.contractExtMapper.updateLastTokenId(tokenId, address);
		return tokenId;

	}

	public FcContract getByShort(String shortUrl) {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.eq(FcContract.SHORT_URL, shortUrl).eq(FcContract.DELETED, false);
		return this.baseService.getByCondition(FcContract.class, wrapper);
	}

	/**
	 * @param addrList
	 * @return
	 */
	public List<FcContract> findListByAdress(List<String> addrList) {
		QueryWrapper<FcContract> wrapper = new QueryWrapper<>();
		wrapper.in(FcContract.ADDRESS, addrList).eq(BaseEntity.DELETED, false);
		return this.baseService.findByCondition(FcContract.class, wrapper);
	}
}
