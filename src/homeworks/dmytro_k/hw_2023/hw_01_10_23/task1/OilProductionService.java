package homeworks.dmytro_k.hw_2023.hw_01_10_23.task1;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 1) Добыча нефти
 * <p>
 * Компания, занимающаяся добычей нефти, хочет создать новую цифровую систему.
 * Первое требование касается управления фактическими экстракторами масла.
 * Все экстракторы имеют серийный номер,
 * предполагаемую производительность (сколько они способны извлечь за 24 часа) и количество
 * (сколько они фактически извлекли за 24 часа). Кроме того, некоторые экстракторы могут сообщать о
 * каких-либо сбоях за последние 24 часа.
 * <p>
 * Экстракторы бывают нескольких видов:
 * 1.)Стационарные наземные экстракторы устанавливаются в месте,
 * которое не может измениться после первоначальной настройки.
 * Они не могут сообщать об ошибках.
 * <p>
 * 2)Мобильные наземные экстракторы могут менять местоположение после его установки.
 * Они сообщают об ошибке, если ежедневный
 * объем извлечения составляет менее 25% от производительности.(1)
 * <p>
 * 3)Морские платформы устанавливаются в море (у них нет местоположения)
 * и имеют список основных рабочих.
 * У работника есть имя, должность (рабочий, медик или менеджер) и количество дней,
 * которое он провел на платформе.
 * Все платформы сообщают об ошибке, если они извлекли менее 70% от запланированной мощности (2),
 * у них нет медика (3)
 * или кто-либо из рабочих находится на борту более 14 дней (4).
 * <p>
 * Бизнес интересует пара важных отчетов:
 * ??? Каково количество экстракторов с активными неисправностями?
 * Какие экстракторы извлекли более 95% своей мощности за последние 24 часа?
 */

public class OilProductionService {
    private final List<Extractor> EXTRACTORS = new LinkedList<>();
    private static final double MAX_PERCENT = 0.95;

    public void addExtractor(Extractor extractor) {
        EXTRACTORS.add(extractor);
    }

    public void topExtractor() {

        Predicate<Extractor> topExtractorPredicate = element ->
                element.getQuantity() > element.getExpectedPerformance() * MAX_PERCENT;

        EXTRACTORS
                .stream()
                .filter(topExtractorPredicate)
                .forEach(System.out::println);
    }

    public void extractorError() {

        Predicate<Extractor> extractorError1 = Extractor::isError;
        Predicate<Extractor> extractorError = element ->
                element.getStatus().equals(Status.ERROR);
//v1
        EXTRACTORS
                .stream()
                .filter(extractorError1)
                .forEach(System.out::println);
//v2
        EXTRACTORS
                .stream()
                .filter(extractorError)
                .forEach(System.out::println);
    }
}
