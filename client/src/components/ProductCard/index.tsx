import AspectRatio from '@mui/joy/AspectRatio';
import Box from '@mui/joy/Box';
import Button from '@mui/joy/Button';
import Card from '@mui/joy/Card';
import IconButton from '@mui/joy/IconButton';
import Typography from '@mui/joy/Typography';

import { ProjectImg } from './Layout';

type CardData = {
    productName: string;
    image: HTMLImageElement;
    price: Number;
  }

export default function ProductCard({ productName, image, price }: CardData) {
  return (
    <Card variant="outlined" sx={{ width: 320, background: '#8f663d' }}>
      <Typography level="h2" fontSize="md" sx={{ mb: 0.5 }}>
        {productName}
      </Typography>
      <IconButton
        aria-label="bookmark Bahamas Islands"
        variant="plain"
        color="neutral"
        size="sm"
        sx={{ top: '0.5rem', right: '0.5rem' }}
      >
      </IconButton>
      <AspectRatio minHeight="120px" maxHeight="200px" sx={{ my: 2 }}>
        <ProjectImg src={image} />
      </AspectRatio>
      <Box sx={{ display: 'flex' }}>
        <div>
          <Typography level="body3">Price:</Typography>
          <Typography fontSize="lg" fontWeight="lg">
            {`$ ${price}`}
          </Typography>
        </div>
        <Button
          variant="solid"
          size="sm"
          color="primary"
          aria-label="Explore Bahamas Islands"
          sx={{ ml: 'auto', fontWeight: 600 }}
        >
          Explore
        </Button>
      </Box>
    </Card>
  );
}
