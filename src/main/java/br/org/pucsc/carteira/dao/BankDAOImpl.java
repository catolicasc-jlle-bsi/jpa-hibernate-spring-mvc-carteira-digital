package br.org.pucsc.carteira.dao;


import org.springframework.stereotype.Component;

import br.org.pucsc.carteira.entity.Bank;

@Component
public class BankDAOImpl extends GenericDAOImpl<Bank, Long> implements BankDAO {

}
