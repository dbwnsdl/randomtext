function random_text(length) {
    let hangul = '';
    const alphabets = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
  
    for (let i = 0; i < length; i++) {
      hangul += String.fromCharCode(Math.floor(Math.random() * (55203 - 44032 + 1)) + 44032);
    }
  
    let combined = '';
    for (let i = 0; i < length * 2; i++) {
      combined += (i % 2 === 0) ? hangul[Math.floor(i / 2)] : alphabets.charAt(Math.floor(Math.random() * alphabets.length));
    }
  
    combined = combined.split('');
    for (let i = combined.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [combined[i], combined[j]] = [combined[j], combined[i]];
    }
  
    return combined.slice(0, length).join('');
}