package org.schabi.newpipe.extractor.services.youtube;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.schabi.newpipe.extractor.ServiceList.YouTube;
import static org.schabi.newpipe.extractor.services.DefaultTests.assertNoMoreItems;
import static org.schabi.newpipe.extractor.services.DefaultTests.defaultTestRelatedItems;

import org.junit.jupiter.api.Test;
import org.schabi.newpipe.extractor.exceptions.ParsingException;
import org.schabi.newpipe.extractor.services.BaseListExtractorTest;
import org.schabi.newpipe.extractor.services.DefaultSimpleExtractorTest;
import org.schabi.newpipe.extractor.services.youtube.extractors.kiosk.YoutubeTrendingExtractor;

public class YoutubeKioskExtractorTest {

    public static class Trending extends DefaultSimpleExtractorTest<YoutubeTrendingExtractor>
        implements BaseListExtractorTest, InitYoutubeTest {

        @Override
        protected YoutubeTrendingExtractor createExtractor() throws Exception {
            return (YoutubeTrendingExtractor) YouTube.getKioskList().getDefaultKioskExtractor();
        }

        @Override
        @Test
        public void testServiceId() {
            assertEquals(YouTube.getServiceId(), extractor().getServiceId());
        }

        @Override
        @Test
        public void testName() throws Exception {
            assertEquals("Trending", extractor().getName());
        }

        @Override
        @Test
        public void testId() throws Exception {
            assertEquals("Trending", extractor().getId());
        }

        @Override
        @Test
        public void testUrl() throws ParsingException {
            assertEquals("https://www.youtube.com/feed/trending", extractor().getUrl());
        }

        @Override
        @Test
        public void testOriginalUrl() throws ParsingException {
            assertEquals("https://www.youtube.com/feed/trending", extractor().getOriginalUrl());
        }

        @Override
        @Test
        public void testRelatedItems() throws Exception {
            defaultTestRelatedItems(extractor());
        }

        @Override
        @Test
        public void testMoreRelatedItems() throws Exception {
            assertNoMoreItems(extractor());
        }
    }
}
