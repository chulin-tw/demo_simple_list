const express = require('express');
const app = express();
const PORT = 3022;

const data = [
    {
        image: "https://pic.imgdb.cn/item/6726249cd29ded1a8cb01934.jpg",
        title: "Serenity of the Azure Sky",
        description: "This stunning bluebird, perched gracefully among the vibrant green foliage, embodies the tranquility of nature. With its vivid azure feathers glistening in the sunlight, it captures the essence of a peaceful morning, inviting us to pause and appreciate the beauty that surrounds us.."
    },
    {
        image: "https://pic.imgdb.cn/item/6726251bd29ded1a8cb07a95.jpg",
        title: "Playful Paws",
        description: "Five adorable kittens frolic together, their playful antics bringing joy and laughter. Each one is unique, showcasing a delightful mix of colors and personalities."
    },
    {
        image: "https://pic.imgdb.cn/item/67262577d29ded1a8cb0c0ab.jpg",
        title: "Joyful Pup",
        description: "This cheerful puppy radiates happiness, wagging its tail and ready for play. With bright eyes and a playful spirit, it brings joy to everyone around."
    },
    {
        image: "https://pic.imgdb.cn/item/672625bfd29ded1a8cb0fde8.jpg",
        title: "Majestic White Goose",
        description: "This elegant white goose stands proudly by the water's edge, its pristine feathers glistening in the sunlight. With a graceful demeanor, it adds a touch of serenity to the landscape."
    },
    {
        image: "https://pic.imgdb.cn/item/6726261ad29ded1a8cb1496e.jpg",
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
