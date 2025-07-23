function getVideoId(url) {
  const match = url.match(/(?:https?:\/\/)?(?:www\.)?(?:youtube\.com\/(?:watch\?v=|embed\/)|youtu\.be\/)([\w-]{11})/);
  return match ? match[1] : null;
}

function getThumbnail() {
  const url = document.getElementById("urlInput").value;
  const videoId = getVideoId(url);

  if (!videoId) {
    alert("Invalid YouTube URL");
    return;
  }

  const qualities = ["default", "mqdefault", "hqdefault", "sddefault", "maxresdefault"];
  const container = document.getElementById("thumbnails");
  container.innerHTML = "";

  qualities.forEach(q => {
    const imgUrl = `https://img.youtube.com/vi/${videoId}/${q}.jpg`;
    container.innerHTML += `
      <div>
        <p>${q}</p>
        <img src="${imgUrl}" alt="${q}" style="width:320px"><br>
        <a href="${imgUrl}" download target="_blank">Download</a>
      </div>
      <hr/>
    `;
  });
}
