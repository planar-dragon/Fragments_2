package com.skillbox.ExtensionsObjectsEnums

fun main() {
    Currency.RUBEL
    Currency.DOLLAR
    Currency.EURO

// 9. Создайте два разных кошелька, добавьте в них немного денег в разных валютах, сравните значения кошельков.
// Выведите на экран содержимое кошельков (после конвертации в доллары).

    val WalletInHand = Wallets.RealWallets() // кошелек в руках
    val CardWallet =
        Wallets.VirtualWallets() // деньги на карте

// Пополняем кошелек в руках:

    with(WalletInHand) {

        addMoneyToRealWallets(Currency.DOLLAR, 12, 15)
        addMoneyToRealWallets(Currency.RUBEL, 1000, 2)
        addMoneyToRealWallets(Currency.EURO, 16, 9)
    }

// Пополняем деньги на карте:

    with(CardWallet) {
        addMoneyToVirtualWallet(Currency.DOLLAR, 9.0)
        addMoneyToVirtualWallet(Currency.RUBEL, 3580.5)
        addMoneyToVirtualWallet(Currency.EURO, 12.3)
    }

// Выводим колличество денег на кошельках:

    println("Денег на руках: ${String.format("%.2f", WalletInHand.moneyInUSD())} долларов")
    println("Денег на карте: ${String.format("%.2f", CardWallet.moneyInUSD())} долларов")
    println()

// Сравниваем значения кошельков:

    println("Что делать: ")
    if (WalletInHand.moneyInUSD() > CardWallet.moneyInUSD())
        println("Деньги есть, гуляем!")
    else println("Надо снять деньги с карты")

}


