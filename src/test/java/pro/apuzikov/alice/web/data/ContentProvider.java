package pro.apuzikov.alice.web.data;

public class ContentProvider {

    public static String getTestDefaultContent() {
        return "{\n" +
                "  \"meta\": {\n" +
                "    \"locale\": \"ru-RU\",\n" +
                "    \"timezone\": \"Europe/Moscow\",\n" +
                "    \"client_id\": \"ru.yandex.searchplugin/5.80 (Samsung Galaxy; Android 4.4)\",\n" +
                "    \"interfaces\": {\n" +
                "      \"screen\": { }\n" +
                "    }\n" +
                "  },\n" +
                "  \"request\": {\n" +
                "    \"command\": \"закажи пиццу на улицу льва толстого, 16 на завтра\",\n" +
                "    \"original_utterance\": \"закажи пиццу на улицу льва толстого, 16 на завтра\",\n" +
                "    \"type\": \"SimpleUtterance\",\n" +
                "    \"markup\": {\n" +
                "      \"dangerous_context\": true\n" +
                "    },\n" +
                "    \"payload\": {},\n" +
                "    \"nlu\": {\n" +
                "      \"tokens\": [\n" +
                "        \"закажи\",\n" +
                "        \"пиццу\",\n" +
                "        \"на\",\n" +
                "        \"льва\",\n" +
                "        \"толстого\",\n" +
                "        \"16\",\n" +
                "        \"на\",\n" +
                "        \"завтра\"\n" +
                "      ],\n" +
                "      \"entities\": [\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 2,\n" +
                "            \"end\": 6\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.GEO\",\n" +
                "          \"value\": {\n" +
                "            \"house_number\": \"16\",\n" +
                "            \"street\": \"льва толстого\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 3,\n" +
                "            \"end\": 5\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.FIO\",\n" +
                "          \"value\": {\n" +
                "            \"first_name\": \"лев\",\n" +
                "            \"last_name\": \"толстой\"\n" +
                "          }\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 5,\n" +
                "            \"end\": 6\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.NUMBER\",\n" +
                "          \"value\": 16\n" +
                "        },\n" +
                "        {\n" +
                "          \"tokens\": {\n" +
                "            \"start\": 6,\n" +
                "            \"end\": 8\n" +
                "          },\n" +
                "          \"type\": \"YANDEX.DATETIME\",\n" +
                "          \"value\": {\n" +
                "            \"day\": 1,\n" +
                "            \"day_is_relative\": true\n" +
                "          }\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"session\": {\n" +
                "    \"new\": true,\n" +
                "    \"message_id\": 4,\n" +
                "    \"session_id\": \"2eac4854-fce721f3-b845abba-20d60\",\n" +
                "    \"skill_id\": \"3ad36498-f5rd-4079-a14b-788652932056\",\n" +
                "    \"user_id\": \"AC9WC3DF6FCE052E45A4566A48E6B7193774B84814CE49A922E163B8B29881DC\"\n" +
                "  },\n" +
                "  \"version\": \"1.0\"\n" +
                "}";
    }
}
