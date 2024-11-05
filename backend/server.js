const express = require('express');
const app = express();
const PORT = 3022;

const data = [
    {
        image: "https://files.superbed.cn/proxy/7468686c6f2633336b776c74736873327f7872327e7f797e736f327f7371337e242f24257e292c287a7f2e78292a2e78292d7d7f2f7e787a2b2d2d252c797a2b2a7f2a2a7f287e32766c7b.jpg",
        title: "Serenity of the Azure Sky",
        description: "This stunning bluebird, perched gracefully among the vibrant green foliage, embodies the tranquility of nature. With its vivid azure feathers glistening in the sunlight, it captures the essence of a peaceful morning, inviting us to pause and appreciate the beauty that surrounds us.."
    },
    {
        image: "https://files.superbed.cn/proxy/7468686c6f2633336b776c74736873327f7872327e7f797e736f327f7371332b2b2c25287e2f2a7d7f7d7a2e797878792d252529257e2525782d2c2c2d79252f252c2d252f2b2d32766c7b.jpg",
        title: "Playful Paws",
        description: "Five adorable kittens frolic together, their playful antics bringing joy and laughter. Each one is unique, showcasing a delightful mix of colors and personalities."
    },
    {
        image: "https://files.superbed.cn/proxy/7468686c6f2633336b776c74736873327f7872327e7f797e736f327f7371332f297d242979787a24787e2d7f7e2d2f2e2f7e2b2e7f282f7f782928292a2879252f2924287e242b32766c7b.jpg",
        title: "Joyful Pup",
        description: "This cheerful puppy radiates happiness, wagging its tail and ready for play. With bright eyes and a playful spirit, it brings joy to everyone around."
    },
    {
        image: "https://files.superbed.cn/proxy/7468686c6f2633336b776c74736873327f7872327e7f797e736f327f7371332d792f2c79252e287e2425257d252c2d7d7e2c2d28242a2a2c7825292c7d2b7e2c2e2c247a297d7932766c7b.jpg",
        title: "Majestic White Goose",
        description: "This elegant white goose stands proudly by the water's edge, its pristine feathers glistening in the sunlight. With a graceful demeanor, it adds a touch of serenity to the landscape."
    },
    {
        image: "https://files.superbed.cn/proxy/7468686c6f2633336b776c74736873327f7872327e7f797e736f327f7371337e2e2d7e7e2c292d7a242d25242a2d24792c29297a7f7828297d79782e792b2f247e7828792a292832766c7b.jpg",
        title: "King of the Savanna",
        description: "This majestic lion commands attention with its powerful presence and flowing mane. A symbol of strength and courage, it embodies the wild beauty of the African plains."
    }
];

app.get('/list', (req, res) => {
    res.json(data);
});

app.listen(PORT, () => {
    console.log(`Server is running at http://localhost:${PORT}/list`);
});
