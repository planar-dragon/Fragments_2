package com.skillbox.ExtensionsObjectsEnums

import java.nio.channels.spi.AbstractSelectionKey

//    6. Создайте sealed класс Wallets, который реализует два типа кошельков, виртуальный и реальный:

sealed class Wallets() {

//    8. У класса Wallets объявите абстрактный метод moneyInUSD,
//    возвращающий количество денег в кошельке в пересчёте на доллары США.

    var moneyAdded: Double? = null // переменная добавления денег заполняемая позжу

    abstract fun moneyInUSD(): Double

    //    6.1. Виртуальный кошелёк хранит значения валют в виде трёх отдельных переменных типа Double.
//    Все переменные должны быть закрыты для изменения снаружи
//    (дальше мы напишем функцию для обработки такого функционала).
//    наследник класса Wallets - класс VirtualWallets (виртуальный кошелек)

    class VirtualWallets() : Wallets() {
        private var amountOfMoneyRubel: Double = 0.0
        private var amountOfMoneyDollar: Double = 0.0
        private var amountOfMoneyEuro: Double = 0.0

//    7. Для каждого класса создайте методы addMoney, добавляющие в кошелёк деньги:
//    7.1. Для виртуального кошелька метод должен принимать два аргумента: тип валюты и количество добавляемых денег.

        fun addMoneyToVirtualWallet(currency: Currency, moneyAdded: Double) {
            when (currency) {
                Currency.RUBEL -> amountOfMoneyRubel += moneyAdded
                Currency.DOLLAR -> amountOfMoneyDollar += moneyAdded
                Currency.EURO -> amountOfMoneyEuro += moneyAdded

            }
        }

//    Реализуйте метод moneyInUSD для каждого из наследников.

        override fun moneyInUSD():
        Double = amountOfMoneyDollar + amountOfMoneyRubel * Currency.CurrencyConverter.rubelToUSD + amountOfMoneyEuro * Currency.CurrencyConverter.euroToUSD

//      так не получается >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//      Double = amountOfMoneyDollar + Currency.RUBEL.convertToUSD(amountOfMoneyRubel) + Currency.EURO.convertToUSD(amountOfMoneyEuro)

    }
//    6.2. Реальный кошелёк хранит каждую валюту в виде приватного свойства MutableMap<Int, Int>,
//    где в качестве ключа выступает номинал купюры, а в качестве значения — количество купюр.

    class RealWallets() : Wallets() {
//    реальный кошелек только целые числа, поэтому Int

        private var amountOfMoneyRubel: MutableMap<Int, Int> = mutableMapOf()
        private var amountOfMoneyDollar: MutableMap<Int, Int> = mutableMapOf()
        private var amountOfMoneyEuro: MutableMap<Int, Int> = mutableMapOf()

//    7. Для каждого класса создайте методы addMoney, добавляющие в кошелёк деньги:
//    7.2. Для реального кошелька понадобится три аргумента: тип валюты, номинал купюры, количество купюр

        fun addMoneyToRealWallets(currency: Currency, nominalOfBills: Int, numberOfBills: Int) {
            when (currency) {
                Currency.RUBEL -> amountOfMoneyRubel[nominalOfBills] = numberOfBills // nominalOfBills - номинал купюры
                Currency.EURO -> amountOfMoneyEuro[nominalOfBills] = numberOfBills // numberOfBills - количество купюр
                Currency.DOLLAR -> amountOfMoneyDollar[nominalOfBills] = numberOfBills

            }
        }

//    Реализуйте метод moneyInUSD для каждого из наследников.

        override fun moneyInUSD(): Double {
            var sumOfRubels: Int = 0

            amountOfMoneyRubel.forEach { (nominalOfBills, numberOfBills) ->
                sumOfRubels += nominalOfBills * numberOfBills
            }

            var sumOfDollars: Int = 0

            amountOfMoneyEuro.forEach { (nominalOfBills, numberOfBills) ->
                sumOfDollars += nominalOfBills * numberOfBills
            }

            var sumOfEuro: Int = 0

            amountOfMoneyDollar.forEach { (nominalOfBills, numberOfBills) ->
                sumOfEuro += nominalOfBills * numberOfBills
            }
// Суммируем все деньги в долларах
            var sumOfMoney =
                sumOfDollars + sumOfRubels * Currency.CurrencyConverter.rubelToUSD + sumOfEuro * Currency.CurrencyConverter.euroToUSD
            return sumOfMoney // как результат функции выводится sumOfMoney
        }
    }
}





















