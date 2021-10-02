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

    class VirtualWallets : Wallets() {
        private var amountOfMoneyRubel: Double = 0.0
        private var amountOfMoneyDollar: Double = 0.0
        private var amountOfMoneyEuro: Double = 0.0

//    7. Для каждого класса создайте методы addMoney, добавляющие в кошелёк деньги:
//    7.1. Для виртуального кошелька метод должен принимать два аргумента: тип валюты и количество добавляемых денег.

        fun addMoneyToVirtualWallet(currency: Currency, moneyAdded: Double) {
            return when (currency) {
                Currency.RUBEL -> amountOfMoneyRubel += moneyAdded
                Currency.DOLLAR -> amountOfMoneyDollar += moneyAdded
                Currency.EURO -> amountOfMoneyEuro += moneyAdded

            }
        }

//    Тут я застрял >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
//    Реализуйте метод moneyInUSD для каждого из наследников.

        override fun moneyInUSD(): Double {
            return when (addMoneyToVirtualWallet(currency, moneyAdded)){
                Currency.RUBEL -> amountOfMoneyRubel * Currency.conversionToDollar.rubelToUSD
                Currency.DOLLAR -> amountOfMoneyRubel * Currency.conversionToDollar.rubelToUSD
                Currency.EURO -> amountOfMoneyRubel * Currency.conversionToDollar.rubelToUSD
                else -> 0.0
                            }
        }
    }
//    6.2. Реальный кошелёк хранит каждую валюту в виде приватного свойства MutableMap<Int, Int>,
//    где в качестве ключа выступает номинал купюры, а в качестве значения — количество купюр.

        class RealWallets : Wallets() {
//    реальный кошелек только целые числа, поэтому Int
            private var amountOfMoneyRubel: Int = 0
            private var amountOfMoneyDollar: Int = 0
            private var amountOfMoneyEuro: Int = 0

            private val realWallets = mutableMapOf<Int, Int>(
                1 to 0,
                5 to 0,
                10 to 0,
                50 to 0,
                100 to 0

            )
//     7.2. Для реального кошелька понадобится три аргумента: тип валюты, номинал купюры, количество купюр

            fun addMoneyToRealWallets(currency: Currency, realWallets: MutableMap<Int, Int>) {
                return when (currency) {
                    Currency.RUBEL -> realWallets.values += amountOfMoneyRubel
                    Currency.DOLLAR -> realWallets.values += amountOfMoneyDollar
                    Currency.EURO -> realWallets.values += amountOfMoneyEuro
                }
            }

        override fun moneyInUSD() {
            TODO("Not yet implemented")
            }
        }


}

