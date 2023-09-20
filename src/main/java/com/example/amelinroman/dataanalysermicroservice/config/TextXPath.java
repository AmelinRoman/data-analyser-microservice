package com.example.amelinroman.dataanalysermicroservice.config;

import com.jcabi.xml.XML;
import lombok.RequiredArgsConstructor;

/**
 * Класс TextXPath предоставляет функционал для извлечения текста из XML-узла, используя XPath.
 */
@RequiredArgsConstructor
public class TextXPath {

    private final XML xml;
    private final String node;

    /**
     * Создает строку, представляющую текст из заданного узла XML-документа, указанного с помощью XPath выражения.
     *
     * @return Строка с текстом из заданного узла.
     */
    @Override
    public String toString() {
        return this.xml.nodes(node)
                .get(0)
                .xpath("text()")
                .get(0);
    }
}
