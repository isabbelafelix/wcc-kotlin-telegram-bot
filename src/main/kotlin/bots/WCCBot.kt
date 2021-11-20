package bots


import org.telegram.telegrambots.bots.TelegramLongPollingBot

import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage


import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update

import org.telegram.telegrambots.meta.exceptions.TelegramApiException


class WCCBot : TelegramLongPollingBot() {


    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "tattoobot"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return "2111542923:AAHMIA15da5P1DF-oH-BVAAs18O2nPeVxAM"
    }


    // AQUI ONDE RECEBE A MENSAGEM
    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName  // O NOME DE QUEM PEGOU A MENSAGEM
        val chatId = update?.message?.chatId.toString() // O ID DO CHAT - PARA RETORNAR A RESPOSTA
        val messageCommand = update?.message?.text // O COMANDO DA MENSAGEM QUE ELA MANDOU


        val welcome = """
        *Olá $nameSender, tudo bem\?*
        
        Sei que você está anciosx para realizar sua tattoo, então aqui vai algumas dicas para você se preparar pra esse momento especial e único
        
        \/start \
        \/referencias \- Aqui você encontra referencias para sua tattoo
        \/pretattoo \- Dicas de como deixar sua pele ideal na hora da agulhada
        \/postattoo \- Dicas de como deixar ela pretinha e cicatrizada 
        \/playlisttattoo \
        
    """.trimMargin()


        try {


            if(messageCommand=="/start") {
                val sendMessage = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = welcome
                    this.document = InputFile().setMedia("https://media.giphy.com/media/qY0Y07cgqA5c4/giphy.gif")
                    this.parseMode = "MarkdownV2"
                }

                execute(sendMessage)

            }

            else if (messageCommand=="/referencias"){
                val sendDocument = SendMessage().apply {
                    this.chatId = chatId
                    this.text = """
                         https\:\/\/br\.pinterest\.com
                    """.trimIndent()
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)
            }

            else if (messageCommand=="/pretattoo"){
                val sendDocument = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = """
                        *Dica número 1* – Beba muita água na semana anterior a sessão\.
                        *Dica número 2* – Hidrate a região que será tatuada\.
                        *Dica número 3* – Não faça uso de drogas ou beba álcool no dia anterior\.
                        *Dica número 4* – Não faça uso de nenhum anti\-inflamatório\, AAS \(aspirina\) ou qualquer outro medicamento para dor e febre no dia anterior ou no dia da sessão\.
                        *Dica número 5* – Se alimente bem antes da sessão\.
                        *Dica número 6* – Planeje sua rotina de acordo com o local da sua nova tatuagem\.
                        *Dica número 7* – Fique de olho na sua saúde\!
                    """.trimIndent()
                    this.document = InputFile().setMedia("https://media.giphy.com/media/wlU4ia3EtAcTOcZczJ/giphy.gif")
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)


            }

            else if (messageCommand=="/postattoo"){
                val sendDocument = SendDocument().apply {
                    this.chatId = chatId
                    this.caption = """
                        *Dica número 1* – Faça a higienização corretamente
                        *Dica número 2* – Passe um produto cicatrizante corretamente
                        *Dica número 3* – Vá com calma no papel filme de plástico 
                        *Dica número 4* – Vai dar vontade, mas NÃO coce\!
                        *Dica número 5* – Deixe as casquinhas saírem sozinhas
                        *Dica número 6* – Evite o sol\, praias, piscinas e lagos
                        *Dica número 7* – Evite alimentos gordurosos
                    """.trimIndent()
                    this.document = InputFile().setMedia("https://media.giphy.com/media/xT5LMB9LEpfjjakHXG/giphy.gif")
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)


            }

            else if (messageCommand=="/playlisttattoo"){
                val sendDocument = SendMessage().apply {
                    this.chatId = chatId
                    this.text = """
                         https\:\/\/open\.spotify\.com\/playlist\/4Ld7QV812yeo0uPHQ4egsy
                    """.trimIndent()
                    this.parseMode = "MarkdownV2"
                }

                execute(sendDocument)
            }


            else {
                val sendDocument = SendMessage().apply {
                    this.chatId = chatId
                    this.text = "presta atenção"
                    this.parseMode = "MarkdownV2"
                }


                execute(sendDocument)
            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }


}