package com.skillbox.ExtensionsObjectsEnums

//    6. Создайте sealed класс Wallets, который реализует два типа кошельков, виртуальный и реальный:

sealed class Wallets() {

//    8. У класса Wallets объявите абстрактный метод moneyInUSD,
//    возвращающий количество денег в кошельке в пересчёте на доллары США.

    abstract var moneyAdded: Double

    abstract fun moneyInUSD()

    //    6.1. Виртуальный кошелёк хранит значения валют в виде трёх отдельных переменных типа Double.
//    Все переменные должны быть закрыты для изменения снаружи
//    (дальше мы напишем функцию для обработки такого функционала).
//    наследник класса Wallets - класс VirtualWallets (виртуальный кошелек)

    class VirtualWallets(override var moneyAdded: Double) : Wallets() {
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

        override fun moneyInUSD(): Double = amountOfMoneyDollar + Currency.convertToUSD(Rubel){

        }


    }
//    6.2. Реальный кошелёк хранит каждую валюту в виде приватного свойства MutableMap<Int, Int>,
//    где в качестве ключа выступает номинал купюры, а в качестве значения — количество купюр.

        class RealWallets(override var moneyAdded: Double) : Wallets() {
//    реальный кошелек только целые числа, поэтому Int

        private var currencyRubel: Int = 0 // тип валюты
        private var currencyDollar: Int = 0
        private var currencyEuro: Int = 0

        val realWallet: MutableMap<Int, Int> = mutableMapOf(
          1 to 20, // номинал и колличество купюр этого номинала
          5 to 10,
          10 to 7,
          50 to 3,
          100 to 2
        )

//     7.2. Для реального кошелька понадобится три аргумента: тип валюты, номинал купюры, количество купюр

        fun addMoneyToRealWallets(currency: Currency, nominalOfBills: Int, numberOfBills: Double) {
            var moneyInUSD = 0.0
            var nominalOfBills = realWallet.keys
            var numberOfBills = realWallet.values
// тут не понимаю как просчитать и суммировать все деньги с помощью номинала и колличества купюр >>>>>>>>>>>>>>
            Currency.RUBEL ->
                 nominalOfBills * numberOfBills * Currency.conversionToDollar.rubelToUSD,

            if (this = currency.RUBEL) moneyInUSD = nominalOfBills * numberOfBills * Currency.conversionToDollar.rubelToUSD,
            if (this = currency.RUBEL) moneyInUSD = nominalOfBills * numberOfBills * Currency.conversionToDollar.rubelToUSD,
            return moneyInUSD
        }
            for ((nominalOfBills,numberOfBills) in realWallet){
                print (it)

            }            }




//        {
//            ключ тип валюты: {
//            ключ номинал купюры: число - количество купюр
//        }
//        }
        fun sumOfTypeCurrency(
            currencyRubel: MutableMap<String, String>,
            realWallet.keys: = numberOfBills) {
} ->

        fun addMoneyToRealWallets() {
            Currency.RUBEL to amountOfMoneyRubel += realWallets.values
            Currency.DOLLAR to realWallets.values += amountOfMoneyDollar
            Currency.EURO to realWallets.values += amountOfMoneyEuro
            }

        val numberOfBills = $realWallet.keys * $realWallet.size





//        for (userNumber in mutableList)
//            println(${realRubelWallet.key} * S{realRubelWallet.value})

//        fun addMoneyToRealWallets() {
//        val One = EnumRealWallets.ONE.numberOfBills
//        val Five = EnumRealWallets.FIVE.numberOfBills
//        val Ten = EnumRealWallets.TEN.numberOfBills
//        val Fifty = EnumRealWallets.FIFTY.numberOfBills
//        val Hundred = EnumRealWallets.HUNDRED.numberOfBills
//
//
////    for (nominalMoney in mutableListOfBills) {
////                EnumRealWallets.ONE: 20,
////                EnumRealWallets.FIVE: 10
////                EnumRealWallets.TEN: 7
////                EnumRealWallets.FIFTY: 3
////                EnumRealWallets.HUNDRED: 2
////
////        fun amountOfMoneyRubel(): Float {
////            return EnumRealWallets.ONE * EnumRealWallets.ONE.numberOfBills
////        }
////        private var typeOfMoneyRubel: Int = 0 // тип валюты
////        private var typeOfMoneyDollar: Int = 0
////        private var typeOfMoneyEuro: Int = 0
//
//
//            }



}


















